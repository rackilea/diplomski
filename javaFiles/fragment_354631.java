public class TestExecute
{  
   TestLogic1 method1=new TestLogic1();
   TestLogic2 method2=new TestLogic2();

   @Test(priority=1)
   public void test1()
    {
       method1.testMethod1();
    }
@Test(priority=2)
   public void test2()
    {
       method2.testMethod2();
    }
}