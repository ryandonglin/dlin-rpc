package xyz.dlin.rpc.simpleinvoke.handler;


import xyz.dlin.rpc.simpleinvoke.protocol.InvokeRpcProtocol;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author donglin
 * @date 17/3/2018 10:30 PM
 * @since 1.0
 */
public class ServerHandler {

    public void handle(InvokeRpcProtocol protocol) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class invoker = protocol.getInvoker();
        Method method = invoker.getMethod(protocol.getMethodName(), protocol.getmParameterTypes());
        method.invoke(invoker.newInstance(), protocol.getParameters());
    }

}
