public abstract class LazilyLoadedObject implements InvocationHandler {

    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (target == null) {
            target = loadObject();
        }
        return method.invoke(target, args);
    }

    /**
     * Loads the proxied object. This might be an expensive operation
     * or loading lots of objects could consume a lot of memory, so
     * we only load the object when it's needed.
     */
     protected abstract Object loadObject();

}