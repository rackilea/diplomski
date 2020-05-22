public class NoScriptInterceptor implements Interceptor {

    private static final long serialVersionUID = -1472114260682759961L;

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        final ActionContext context = invocation.getInvocationContext();

        String actionName = Utils.toCamelCase(invocation.getAction().getClass().getName());

        Map<String,Object> parameters = (Map<String,Object>)context.get(ActionContext.PARAMETERS);

        Object noScriptParam = parameters.get(actionName + ".noScript");
        if (noScriptParam != null) {
            return Constants.NO_SCRIPT;
        }

        return invocation.invoke();
    }

}