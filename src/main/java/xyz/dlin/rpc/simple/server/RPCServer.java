package xyz.dlin.rpc.simple.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import xyz.dlin.rpc.simple.Protocol.RpcProtocol;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ${DESCRIPTION}
 *
 * @author donglin
 * @version 1.0.0
 * @date 2018/3/16
 * @since 1.0.0
 */
public class RPCServer {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(3306);

        while (true) {
            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            PrintStream out = new PrintStream(socket.getOutputStream());
            String line = br.readLine();
            RpcProtocol protocol = mapper.readValue(line, RpcProtocol.class);
            try {
                Class obj = Class.forName(protocol.getClassName());
                Method[] methods = obj.getMethods();
                boolean methodExists = false;
                Class<?>[] parameterTypes = null;
                for (Method method : methods) {
                    if (method.getName().equalsIgnoreCase(protocol.getMethodName())) {
                        methodExists = true;
                        parameterTypes = method.getParameterTypes();
                        break;
                    }
                }

                if (methodExists) {
                    Method method;
                    method = obj.getMethod(protocol.getMethodName(), protocol.getParameterTypes());
                    method.invoke(obj.newInstance(), protocol.getArgs());
                } else {

                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (NoSuchMethodException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }

    }
}
