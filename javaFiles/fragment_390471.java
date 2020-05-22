public static SomeInterface create() {
    return (SomeInterface)Proxy.newProxyInstance(MyProxy.class.getClassLoader(), new Class[]{SomeInterface.class}, new InvocationHandler() {
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if ("method1".equals(method.getName())) {
                // Some special logic for this method
                return null;
            } else {
                // delegate all other methods
                return method.invoke(proxy, args);
            }
        }
    });
}