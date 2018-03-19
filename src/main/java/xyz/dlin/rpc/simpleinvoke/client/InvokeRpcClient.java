package xyz.dlin.rpc.simpleinvoke.client;

import xyz.dlin.rpc.simple.service.RemoteService;
import xyz.dlin.rpc.simple.service.RemoteServiceImpl;
import xyz.dlin.rpc.simpleinvoke.handler.ClientHandler;

/**
 * @author donglin
 * @date 17/3/2018 9:51 PM
 * @since 1.0
 */
public class InvokeRpcClient<T> {

    public static void main(String[] args) {
        ClientHandler handler = new ClientHandler();
        RemoteService remoteService = (RemoteService) handler.createObject(new RemoteServiceImpl());
        remoteService.sayHello("hahahahahha");
    }
}
