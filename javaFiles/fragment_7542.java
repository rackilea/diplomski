public class Outer {
    class A {
       private int a;
       ...
    }
    class B extends A {
        private int b1 = a;  // Compilation error
        // field 'a' is still accessible!
        private int b2 = ((A this).a;   // OK!
    }
}