public class A {
   protected int a; // 'protected' so subclass can see it
   protected int b;

   public A() {
       setup(); // Runs whatever setup method is implemented, even in subclasses
   }

   protected void setup() { /* nothing */ }  // 'protected' to be overridden by subclass
}

public class B extends A {

   public B()
   {
      super();
   }

   /**
    *  When A's constructor calls setup(), this method will run.
    */
   @Override
   protected void setup() {
      Scanner scanner = new Scanner(System.in);
      a = scanner.nextInt(); // Stores value in A's protected variable.
      b = scanner.nextInt();
   }  
}