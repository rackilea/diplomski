public class Child extends Parent {
   @Before
   public void before(){
       System.out.println("Child Before");
   }

   @After
   public void after(){
       System.out.println("Child After");
   }

   @Test
   public void test(){
       System.out.println("Running Test");
   }
}