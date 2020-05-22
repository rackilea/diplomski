package cglibtest;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibTest
{
    public static void main(String... args)
    {
        MyAbstract instance = (MyAbstract)Enhancer.create(MyAbstract.class, new MyInterceptor(42));
        System.out.println("Value from instance: " + instance.valueMethod());
    }

    public static class MyInterceptor implements MethodInterceptor
    {
        private final Object constantValue;

        public MyInterceptor(Object constantValue)
        {
            this.constantValue = constantValue;
        }

        @Override
        public Object intercept(Object obj, Method method, Object[] args,
                MethodProxy proxy) throws Throwable
        {
            if ("valueMethod".equals(method.getName()))
                return(constantValue);
            else
                return(null);
        }
    }

    public static abstract class MyAbstract
    {
        public abstract int valueMethod();
    }
}