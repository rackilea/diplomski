public class AClass{

   class MyClass<TYPE>{}

   static <R> MyClass<R> functionName(){return null;}

   public static void main(String[] args) {
      AClass.<String>functionName();
   }

}