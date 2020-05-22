public class MyActionProxyFactory extends DefaultActionProxyFactory {

    public MyActionProxyFactory() {
        super();
    }

    @Override
    public ActionProxy createActionProxy(ActionInvocation inv, String namespace, String actionName, String methodName, boolean executeResult, boolean cleanupContext) {

        MyActionProxy proxy = new MyActionProxy(inv, namespace, actionName, methodName, executeResult, cleanupContext);
        container.inject(proxy);
        container.setScopeStrategy(new MyScopeStrategy());
        proxy.prepare();
        return proxy;
    }
}

public class MyActionProxy extends DefaultActionProxy {

    protected MyActionProxy(ActionInvocation inv, String namespace, String actionName, String methodName, boolean executeResult, boolean cleanupContext) {
        super(inv, namespace, actionName, methodName, executeResult, cleanupContext);
    }

    @Override
    protected void prepare() {
        super.prepare();
    }
}

public class MyScopeStrategy implements Scope.Strategy {

    @Override
    public <T> T findInRequest(Class<T> type, String name, Callable<? extends T> factory) throws Exception {
        return null;
    }

    @Override
    public <T> T findInSession(Class<T> type, String name, Callable<? extends T> factory) throws Exception {

        ActionContext context = ActionContext.getContext();
        SessionMap<String, T> sessionMap = (SessionMap<String, T>) context.getSession();

        if (sessionMap == null) {
            sessionMap = new SessionMap<String, T>(ServletActionContext.getRequest());
            context.setSession((Map<String, Object>) sessionMap);
        }

        T obj = sessionMap.get(name);

        if (obj == null) {
            obj = factory.call();
            sessionMap.put(name, obj);
        }
        return obj;
    }

    @Override
    public <T> T findInWizard(Class<T> type, String name, Callable<? extends T> factory) throws Exception {
        return null;
    }
}