import java.lang.reflect.Field;

public class Test
{
    public static class A
    {
        public String field1;
        public String field2;
    }
    public static void main(String[] args) throws Exception
    {
        A a = new A();
        Object b = a;
        for (Field f : b.getClass().getFields())
        {
            System.out.println(f.getName());
        }

    }
}