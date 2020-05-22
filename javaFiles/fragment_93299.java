public class Parent {
   @Before
   public void before(){
       System.out.println("Parent Before");
   }

   @After
   public void after(){
       System.out.println("Parent After");
   } 
}