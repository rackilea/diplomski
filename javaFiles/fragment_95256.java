import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class FooFactory {

    public Foo makeFoo() {
        return (Foo) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{Foo.class},
                new FooInvocationHandler(new FooImpl()));
    }

    private static class FooImpl implements Foo {
        private boolean enabled = false;

        @Override
        public boolean getEnabled() {
            return this.enabled;
        }

        @Override
        public void setEnabled(boolean enable) {
            this.enabled = enable;
        }

        @Override
        public void bar() {
            System.out.println("Executing method bar");
        }

        @Override
        public void baz() {
            System.out.println("Executing method baz");
        }

        @Override
        public void bat() {
            System.out.println("Executing method bat");
        }

    }

    private static class FooInvocationHandler implements InvocationHandler {

        private FooImpl fooImpl;

        public FooInvocationHandler(FooImpl fooImpl) {
            this.fooImpl = fooImpl;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getDeclaringClass() == Foo.class &&
                !method.getName().equals("getEnabled") &&
                !method.getName().equals("setEnabled")) {

                if (!this.fooImpl.getEnabled()) {
                    return null;
                }
            }

            return method.invoke(this.fooImpl, args);
        }
    }
}