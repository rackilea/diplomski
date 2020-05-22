public class WrapperClass extends MyClass implements MyInterface, InvocationHandler {

    private final MyClass delegate;

    public WrapperClass(MyClass delegate) {
        this.delegate = delegate;
    }

    public static MyInterface wrap(MyClass wrapped) {
        return (MyInterface) Proxy.newProxyInstance(MyClass.class.getClassLoader(), new Class[] { MyInterface.class }, new WrapperClass(wrapped));
    }

    //you may skip this definition, it is only for demonstration
    public void method1() {
        System.out.println("bar");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method m = findMethod(this.getClass(), method);
        if (m != null) {
            return m.invoke(this, args);
        }
        m = findMethod(delegate.getClass(), method);
        if (m != null) {
            return m.invoke(delegate, args);
        }
        return null;
    }

    private Method findMethod(Class<?> clazz, Method method) throws Throwable {
        try {
            return clazz.getDeclaredMethod(method.getName(), method.getParameterTypes());
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

}