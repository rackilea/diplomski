public class Foo {

    private int bar;
    private String baaz;

    public Foo(int bar) {
        this(bar, "");
    }

    public Foo(int bar, String baaz) {
        this.bar = bar;
        this.baaz = baaz;
    }

    public void method1() {
        this.bar++;

        System.out.println(bar);
        System.out.println(baaz);
    }
}