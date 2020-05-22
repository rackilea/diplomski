public interface Loveable {
    boolean isAlive();
}

public static class Cat {
    boolean isAlive() {
        return true;
    }
}

public static class Dog {
    boolean isAlive() {
        return false;
    }
}

public static <T> T getWrapper(final Object obj, final Class<T> intface) {
    InvocationHandler invocationHandler = new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return obj.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes()).invoke(obj, args);
        }
    };
    return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{intface}, invocationHandler);
}

public static void main(String[] args) throws Exception {
    System.out.println(getWrapper(new Cat(), Loveable.class).isAlive());
    System.out.println(getWrapper(new Dog(), Loveable.class).isAlive());
}