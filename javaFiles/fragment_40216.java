import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class Main
{
    public static void main(final String[] argv)
    {
        final Object             object;
        final InvocationHandler  handler;
        final Runnable           runnable;
        final Comparable<Object> comparable;


        handler = new InvocationHandler()
        {
            public Object invoke(final Object   proxy,
                                 final Method   method,
                                 final Object[] args)
                throws Throwable
            {
                System.out.println(proxy.getClass());
                System.out.println(method);
                System.out.println(Arrays.toString(args));
                return (0);
            }
        };

        object = Proxy.newProxyInstance(Main.class.getClassLoader(), 
                                        new Class[] { 
                                            Runnable.class, 
                                            Comparable.class,
                                        }, 
                                        handler);

        runnable = (Runnable)object;
        runnable.run();

        comparable = (Comparable<Object>)object;
        comparable.compareTo("Hello");
    }
}