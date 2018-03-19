package xyz.dlin.rpc.simpleinvoke.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import xyz.dlin.rpc.simpleinvoke.handler.ServerHandler;
import xyz.dlin.rpc.simpleinvoke.protocol.InvokeRpcProtocol;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author donglin
 * @date 19/3/2018 10:58 AM
 * @since 1.0
 */
public class InvokeRpcServer {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(3306);

        while (true) {
            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            PrintStream out = new PrintStream(socket.getOutputStream());
            String line = br.readLine();
            InvokeRpcProtocol protocol = mapper.readValue(line, InvokeRpcProtocol.class);
            try {
                ServerHandler handler = new ServerHandler();
                handler.handle(protocol);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
