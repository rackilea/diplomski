public class B extends A {
   private String b;
   protected String getB() { return b; }
   protected B setB(String b) { this.b=b; return this; }//Fluent method
   @Override
   public String toString() {
      return "B[getA()=" + getA() + ", getB()=" + getB() + "]\n  " 
      + super.toString();
  }
}