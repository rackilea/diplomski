public class C extends B {
   private String c;
   protected String getC() { return c; }
   protected C setC(String c) { this.c=c; return this; }//Fluent method
   @Override
   public String toString() {
      return "C [getA()=" + getA() + ", getB()=" + getB() + ", getC()=" 
             + getC() + "]\n  " + super.toString();
   }
}