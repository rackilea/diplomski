public class Test1 
{

    public static void main(String[] args) 
    {
        Test1 inst = new Test1();

        Test2 inst2 = new Test2(inst); // <- new code

        inst2.doSomething();           // <- new code
    }

    public void fireTest()
    {
        System.out.println("fireTest");
    }

    public Test1()
    {

    }

}