package xyz.dlin.rpc.simpleinvoke.protocol;

import java.io.Serializable;

/**
 * @author donglin
 * @date 19/3/2018 3:59 PM
 * @since 1.0
 */
public class InvokeRpcProtocol implements Serializable{

    private final static long serialVersionUID = 2L;

    private Class invoker;

    private String methodName;

    private Class<?>[] mParameterTypes;

    private Object[] parameters;

    public InvokeRpcProtocol() {
    }

    public InvokeRpcProtocol(Class invoker, String methodName, Class<?>[] mParameterTypes, Object[] parameters) {
        this.invoker = invoker;
        this.methodName = methodName;
        this.mParameterTypes = mParameterTypes;
        this.parameters = parameters;
    }


    public Class getInvoker() {
        return invoker;
    }

    public void setInvoker(Class invoker) {
        this.invoker = invoker;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getmParameterTypes() {
        return mParameterTypes;
    }

    public void setmParameterTypes(Class<?>[] mParameterTypes) {
        this.mParameterTypes = mParameterTypes;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
