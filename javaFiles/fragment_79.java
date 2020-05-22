public class MyInterceptor implements Interceptor {

    public String intercept(ActionInvocation invocation) {
        /*
        This is before Action.execute(),
        and before all interceptors down the stack
        */

        String code = invocation.invoke();

        /*
        This is after Action.execute(),
        the result rendering and all
        interceptors down the stack,
        but before the interceptors
        higher up in the stack.
        */

        return code;
    }

}