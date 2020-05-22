import java.util.*;

abstract class Base {}
class Derived1 extends Base {}
class Derived2 extends Base {}

public class Test
{
    public static void main(String[] args)
    {
        Map<Integer, Class<? extends Base>> map = 
            new HashMap<Integer, Class<? extends Base>>();

        map.put(1, Derived1.class);
        map.put(2, Derived2.class);

        int which = 2; // For example

        Class<? extends Base> clazz = map.get(which);
        if (clazz == null)
        {
            // Invalid choice. Do whatever.
        }
        else
        {
            try
            {
                Base base = clazz.newInstance();
                // Use base
            }
            catch (InstantiationException e)
            {
                // Handle exception or whatever
            }
            catch (IllegalAccessException e)
            {
                // Handle exception or whatever
            }            
        }
    }
}