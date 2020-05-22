public class Snippet
{
   private String instanceVariable;
   private static String staticVariable;

   public String instanceMethod()
   {
      return "instance";
   }

   public static String staticMethod()
   {
      return "static";
   }

   public static void main(String[] args)
   {
      System.out.println(staticVariable); // ok
      System.out.println(Snippet.staticMethod()); // ok

      System.out.println(new Snippet().instanceMethod()); // ok
      System.out.println(new Snippet().instanceVariable); // ok

      System.out.println(Snippet.instanceMethod()); // wrong
      System.out.println(instanceVariable);         // wrong 
   }
}