public class A {

   private B b;

   public A() {
      b = new b(this);
   }

   public aMethodInA() {
      //stuff goes here
   }
}


public class B {

   private A a;

   public B(A a) {
      this.a = a;
   }

   public aMethodCallingMethodsInTheObjectThatInstantiatedMe() {
      a.aMethodInA();
   }
}