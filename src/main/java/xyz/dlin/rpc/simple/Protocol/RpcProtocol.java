package xyz.dlin.rpc.simple.Protocol;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author dongl50@ziroom.com
 * @version 1.0.0
 * @date 2018/3/16
 * @since 1.0.0
 */
public class RpcProtocol {

    private String className;

    private String methodName;

    private List<Object> args;

    public RpcProtocol() {
    }

    public RpcProtocol(String className, String methodName, List<Object> args) {
        this.className = className;
        this.methodName = methodName;
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

    public List<Object> getArgs() {
        return args;
    }

    public void setArgs(List<Object> args) {
        this.args = args;
    }
}
