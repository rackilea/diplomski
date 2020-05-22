public class SomeClass{
   public void somePublicMethod()
   {
       long startTime = System.currentTimeMillis();
       someMethodWhichYouWantToProfile();
       long endTime = System.currentTimeMillis();
       System.out.println("Total execution time: " + (endTime-startTime) + "ms"); 
   }
 }