public class Foo {
    public void someFooMethod() {
    }
    public static void main(String[] args) {
        Foo foo = new Foo();
        Bar bar = new Bar(foo);
        bar.someBarMethod();
    }
}

public class Bar {
    private Foo fooLocalRefence;
    public Bar(Foo foo) {
        this.fooLocalReference = foo;
    }
    public someBarMethod() {
        this.fooLocalReference.someFooMethod();
    }
}