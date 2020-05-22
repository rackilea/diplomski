public class A {
   private String a;
   protected String getA() { return a; }

   //WAY 2 - where you have access to the top level source class.
   protected final <T> T a(T type) { return type; }//This is awesome!       

   protected A setA(String a) { this.a=a; return this; }//Fluent method
   @Override
   public String toString() {
      return "A[getA()=" + getA() + "]";
   }
}