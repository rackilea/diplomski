public class Base {
   public final int x;
   public Base() { 
      x = foo();
   }
   int foo() { return 1; }
}
public class Derived extends Base {
   public final int y;
   public Derived() {
      y = 2;
   }
   int foo() { return y; }
}
Derived d = new Derived();
assert( d.x == d.y );                      // Can this ever fail?