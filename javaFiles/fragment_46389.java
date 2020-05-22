public class Foo {  
   private final String bar = "bar";

   public <T extends Foo> void printFoo(T baz) {
      System.out.println(baz.bar); //bar is not visible
   }
}