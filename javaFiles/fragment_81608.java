class Outer {
    Object somethingInTheOuterObject;

    class Inner {
        // Secretly holds a reference to its outer.

        void f() {
            // Can access my enclosing instance objects.
            Object o = somethingInTheOuterObject;
        }
    }
}

static void f() {
    // Cannot do this.
    new Outer.Inner();
    // Can do this.
    Outer outer = new Outer();
    // Can do this.
    Outer.Inner inner = outer.new Inner();
    // Can even do this.
    Outer.Inner inner1 = new Outer().new Inner();
}