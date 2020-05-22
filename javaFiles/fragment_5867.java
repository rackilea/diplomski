import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main
{
    public static void main(final String[] argv)
    {
        final Main main;

        main = new Main();
        main.foo();
    }

    public void foo()
    {
        final Class clazz;
        final Method method;

        clazz = Main.class;

        try
        {
            method = clazz.getDeclaredMethod("bar", String.class);
            method.invoke(this, "foo");
        }
        catch(final NoSuchMethodException ex)
        {
            // handle it however you want
            ex.printStackTrace();
        }
        catch(final IllegalAccessException ex)
        {
            // handle it however you want
            ex.printStackTrace();
        }
        catch(final InvocationTargetException ex)
        {
            // handle it however you want
            ex.printStackTrace();
        }
    }

    private void bar(final String msg)
    {
        System.out.println("hello from: " + msg);
    }
}