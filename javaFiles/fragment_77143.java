public class A {
   // Constructor
   private A() {
   }

   public static A createObjectA(...) {
      A result = new A();
      // In here transform the XML in a suitable format and set it into the result object.
      // Return the result
      return result;
   }
}