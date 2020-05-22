package foo;

public class Test
{
    public static void main(String[] args)
    {
        ClassLoader loader = Test.class.getClassLoader();
        System.out.println(loader.getResource("foo/Test.class"));
    }
}