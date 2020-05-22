public class Foo {
    private String bar;

    // added this
    private Qux qux;

    public String getBar() {
        return bar;
    }
    public void setBar(String bar) {
        this.bar = bar;
    }

    // added getter and setter
    public Qux getQux() {
        return qux;
    }
    public void setQux(Qux qux) {
        this.qux = bar;
    }
}

public static class Qux {
    private String foobar;
    public String getFoobar() {
        return foobar;
    }
    public void setFoobar(String foobar) {
        this.foobar = foobar;
    }
}