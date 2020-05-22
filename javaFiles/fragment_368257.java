import java.lang.reflect.*;
import java.util.*;

public class Test
{
    public List<String> names;

    public static void main(String [] args)
        throws Exception // Just for simplicity!
    {
        Field field = Test.class.getDeclaredField("names");

        ParameterizedType type = (ParameterizedType) field.getGenericType();

        // List
        System.out.println(type.getRawType());

        // Just String in this case
        for (Type typeArgument : type.getActualTypeArguments())
        {
            System.out.println("  " + typeArgument);
        }
    }
}