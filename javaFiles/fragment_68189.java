public class Foo {

    private String bar;

    @JsonProperty
    public String getBar() {
        return this.bar;
    }
    public void setBar(String bar) {
        this.bar = bar;
    }

    @JsonProperty("another_bar")
    public String getAnotherBar() {
        return this.bar;
    }
}