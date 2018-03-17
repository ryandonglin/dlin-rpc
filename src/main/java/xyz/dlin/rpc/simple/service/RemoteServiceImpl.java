package xyz.dlin.rpc.simple.service;

/**
 * ${DESCRIPTION}
 *
 * @author dongl50@ziroom.com
 * @version 1.0.0
 * @date 2018/3/16
 * @since 1.0.0
 */
public class RemoteServiceImpl implements RemoteService{
    @Override
    public void sayHello(Object name) {
        System.out.println("Hello " + name.toString() +" , remote service method is being called" );
    }
}
