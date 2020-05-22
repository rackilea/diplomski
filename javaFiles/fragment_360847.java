public class A {
   public int counter;
   private int counter2;
   public int getCounter2() { return counter2; }
   public void setCounter2(int c) { counter2 = c; }
}

public class B extends A {
   public void setCounter2(int c) {
      if (c < 0) throw new IllegalArgumentException("counter2 cannot be negative");
      super.setCounter2(c); 
   }
}