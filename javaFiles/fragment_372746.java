class Outer {
   void methodA() { }

   class Inner {
       void methodA() { }

       void method() {
            methodA(); // call my methodA();
            Outer.this.methodA(); // calls the Outer.methodA();
       }
   }
}