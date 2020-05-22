package a;
public class Foo {
    b.Foo foo;
    public void method() {
        foo.method();
    }
}

package b;
public class Foo {
    public void method() {
        // Your new code...
    }
}