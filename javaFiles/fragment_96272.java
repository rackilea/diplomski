class MyHandler implements InvocationHandler {

    private Object serviceObject;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        return method.invoke(serviceObject, args);
    }
}