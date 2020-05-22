interface Foo {
    void bar();
}

class AFoo implements Foo {
    int i;

    @Override
    public void bar() {
        i++;
    }
}

class AnotherFoo implements Foo {
    int i;

    @Override
    public void bar() {
        i--;
    }
}

public class Test {
    public static void main(String[] args) {
        Foo foo = new AFoo();
        foo.bar();
    }
}