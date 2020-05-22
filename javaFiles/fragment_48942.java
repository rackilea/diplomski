public class MyClassInvocationHandler implements InvocationHandler {

    private MyClass target;

    public MyClassInvocationHandler(MyClass target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (method.getDeclaringClass().equals(InterfaceA.class))
                return MyClass.getMethod("doSomethingForA").invoke(target, args);
            else if (method.getDeclaringClass().equals(InterfaceB.class))
                return MyClass.getMethod("doSomethingForB").invoke(target, args);
            else
                throw new UnsupportedOperationException("Unsupported interface: " + method.getDeclaringClass());
        } catch (NoSuchMethodException ex) {
            throw new UnsupportedOperationException("Method not found", ex);
        } catch (IllegalAccessException ex) {
            throw new UnsupportedOperationException("Method was not public", ex);
        } catch (InvocationTargetException ex) {
            // May throw a NullPointerException if there is no target exception
            throw ex.getTargetException();
        }
    }
}