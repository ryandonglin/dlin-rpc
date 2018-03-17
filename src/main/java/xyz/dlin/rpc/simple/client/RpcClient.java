package xyz.dlin.rpc.simple.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import xyz.dlin.rpc.simple.Protocol.RpcProtocol;
import xyz.dlin.rpc.simple.service.RemoteService;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author dongl50@ziroom.com
 * @version 1.0.0
 * @date 2018/3/16
 * @since 1.0.0
 */
public class RpcClient {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 3306);
        socket.setSoTimeout(100000);

        // sokcet输出流，用于发送数据至客户端
        PrintStream out = new PrintStream(socket.getOutputStream());

        Class<?>[] parameterTypes = new Class[1];
        parameterTypes[0] = String.class;

        Object[] parameters = new Object[1];
        parameters[0] = "ziroom";
        RpcProtocol protocol = new RpcProtocol("xyz.dlin.rpc.simple.service.RemoteServiceImpl", "sayHello", parameterTypes,  parameters);

        out.println(mapper.writeValueAsString(protocol));
        System.out.println(mapper.writeValueAsString(protocol));

    }
}
