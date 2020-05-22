abstract public class Parent {
   protected abstract int getK();

   public void print() {
      System.out.println(getK());
   }
} 

public class Child1 extends Parent {
   private static final int CHILD1_K = 1;

   protected int getK() { return CHILD1_K; }
}

public class Child2 extends Parent {
   private static final int CHILD2_K = 2;

   protected int getK() { return CHILD2_K; }
}