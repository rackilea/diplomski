public class HelloInvocationHandler implements MethodInterceptor {

    public Object intercept(Object object, Method method, Object[] args,
         MethodProxy methodProxy) throws Throwable {
     debug( "HelloInvocationHandler: invoke method %s", method.getName());
     return methodProxy.invokeSuper(object, args);
    }
}