public class Foo {

    private String thing;
    private String bar;

    public Foo() {
    }

    @Exclude
    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }
}