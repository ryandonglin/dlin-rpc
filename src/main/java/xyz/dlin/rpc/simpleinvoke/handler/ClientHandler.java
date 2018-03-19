package xyz.dlin.rpc.simpleinvoke.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import xyz.dlin.rpc.simpleinvoke.protocol.InvokeRpcProtocol;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @author donglin
 * @date 17/3/2018 7:53 PM
 * @since 1.0
 */
public class ClientHandler implements InvocationHandler {

    private static ObjectMapper mapper = new ObjectMapper();

    private Object targetObj;

    public Object createObject(Object targetObj) {
        this.targetObj = targetObj;
        return Proxy.newProxyInstance(targetObj.getClass().getClassLoader(),
                targetObj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Class<?>[] mParameterType = method.getParameterTypes();
        Object[] mParameters = args;
        InvokeRpcProtocol rpcProtocol = new InvokeRpcProtocol(targetObj.getClass(), methodName, mParameterType, mParameters);
        recall(rpcProtocol);
        return null;
    }

    private void recall(InvokeRpcProtocol rpcProtocol) throws IOException {

        Socket socket = new Socket("127.0.0.1", 3306);
        socket.setSoTimeout(10000);

        OutputStream os = socket.getOutputStream();

        PrintStream ps = new PrintStream(os);

        ps.println(mapper.writeValueAsString(rpcProtocol));
    }
}
