import java.lang.reflect.Field;

class DataObject
{
    // I don't like public fields; this is *solely*
    // to make it easier to demonstrate
    public String foo;
}

public class Test
{
    public static void main(String[] args)
        // Declaring that a method throws Exception is
        // likewise usually a bad idea; consider the
        // various failure cases carefully
        throws Exception
    {
        Field field = DataObject.class.getField("foo");
        DataObject o = new DataObject();
        field.set(o, "new value");
        System.out.println(o.foo);
    }
}