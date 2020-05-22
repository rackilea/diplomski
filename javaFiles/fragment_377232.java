public class Foo {

    private String foo;
    private BarBaz barBaz;

    @JsonCreator
    public Foo(@JsonProperty("bar") int bar, @JsonProperty("baz") int baz) {
        this.barBaz = new BarBaz();
        this.barBaz.setBar(bar);
        this.barBaz.setBaz(baz);
    }

    //getters and setters...
}

public class BarBaz {

    private int bar;
    private int baz;

    public BarBaz() {

    }

    //getters and setters...
}