public class Foo {

    private Bar test1;

    public Foo() {
        test1 = new Bar();
    }

    public Foo(Bar bar1) {
        test1 = bar1;
    }

    public void setTest1(Bar bar) {
        test1 = bar;
    }

    public static void main(String[] args) {
        Foo f1 = new Foo();
        Foo f2 = new Foo(new Bar());
        f2.setTest1(new Bar());
    }

}