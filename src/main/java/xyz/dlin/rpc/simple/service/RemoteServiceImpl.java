package xyz.dlin.rpc.simple.service;

/**
 * ${DESCRIPTION}
 *
 * @author donglin
 * @version 1.0.0
 * @date 2018/3/16
 * @since 1.0.0
 */
public class RemoteServiceImpl implements RemoteService{
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name.toString() +" , remote service method is being called" );
    }
}
