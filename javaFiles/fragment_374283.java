// Foo.java
package foo;

class SuperFoo {
   public void publicMethod() {
   }
}

public class Foo extends SuperFoo {
}

// Bar.java
package bar;

import foo.Foo;

public class Bar {
    public void test() {
        Foo foo = new Foo();
        foo.publicMethod();
    }
}