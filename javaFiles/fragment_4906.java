public class TestClass extends BaseClass 
{
    public void test() 
    {
        initialize();
        System.out.println(this.test);
    }
    public static void main(String[] args) {
        new TestClass().test();
    }
}