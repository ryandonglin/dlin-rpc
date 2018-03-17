package xyz.dlin.rpc.simple.Protocol;

/**
 * RPC基本通讯协议
 *
 * @author donglin
 * @version 1.0.0
 * @date 2018/3/16
 * @since 1.0.0
 */
public class RpcProtocol {

    private String className;

    private String methodName;

    private Class<?>[] parameterTypes;

    private Object[] args;

    public RpcProtocol() {
    }

    public RpcProtocol(String className, String methodName, Class<?>[] parameterTypes, Object[] args) {
        this.className = className;
        this.methodName = methodName;
        this.parameterTypes = parameterTypes;
        this.args = args;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
