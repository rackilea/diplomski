import java.lang.reflect.Field;

public class VariableNameTest
{
    static final int DRAGON = 5;
    static final int SNAKE = 6;

    public static void main(String[] args)
    {
        System.out.println(getValue("DRAGON"));
        System.out.println(getValue("SNAKE"));
        System.out.println(getValue("Boo!"));
    }

    private static int getValue(String name)
    {
        try
        {
            Class<?> c = VariableNameTest.class;
            Field f = c.getDeclaredField(name);
            return f.getInt(null);
        }
        catch (NoSuchFieldException e)
        {
            // Many things
            e.printStackTrace();
        }
        catch (SecurityException e)
        {
            // may cause
            e.printStackTrace();
        }
        catch (IllegalArgumentException e)
        {
            // this to 
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            // fail horribly 
            e.printStackTrace();
        }
        return 0;
    }
}