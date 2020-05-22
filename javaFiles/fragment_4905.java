public class TestClass
{
    public void test() 
    {
        ChildClass cls =new ChildClass().initialize();
        System.out.println(cls.test);
    }
    public static void main(String[] args) {
        new TestClass().test();
    }
}