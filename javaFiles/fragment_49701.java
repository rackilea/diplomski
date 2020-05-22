package ut.test;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyTest {

    public static class Inner {
        private String data = "hello";

        public Inner() {}

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data;
        }

    }

    public static class Outer {
        private List<Inner> list = Lists.newArrayList(new Inner());

        public Outer() {}

        public List<Inner> getList() {
            return list;
        }

        public void setList(List<Inner> list) {
            this.list = list;
        }
    }

    public static class GetOnlyDelegatingMethodInterceptor implements MethodInterceptor {
        private Object delegate;

        public GetOnlyDelegatingMethodInterceptor(Object delegate) {
            this.delegate = delegate;
        }

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            if (method.getName().startsWith("get")) {
                return makeImmutable(proxy.invoke(delegate, args));
            }

            if (method.getName().equals("toString")) {
                return proxy.invoke(delegate, args);
            }

            if (method.getDeclaringClass().equals(Object.class)) {
                return proxy.invoke(delegate, args);
            }

            // you may check for other methods here

            // skip all others
            return null;
        }
    }

    private static Object makeImmutable(Object obj) {
        if (obj == null) {
            return obj;
        }

        Enhancer e = new Enhancer();
        e.setSuperclass(obj.getClass());
        e.setCallback(new GetOnlyDelegatingMethodInterceptor(obj));
        return e.create();
    }

    @Test
    public void testImmutable() {
        Outer outerImmutable = (Outer) makeImmutable(new Outer());

        // this is initial state
        assertEquals(outerImmutable.getList().toString(), "[hello]");

        // trying to set empty list
        outerImmutable.setList(new ArrayList<>());
        // but it's still the same
        assertEquals(outerImmutable.getList().toString(), "[hello]");

        // going deeper
        outerImmutable.getList().get(0).setData("bye!");
        // but still no changes
        assertEquals(outerImmutable.getList().toString(), "[hello]");
    }
}