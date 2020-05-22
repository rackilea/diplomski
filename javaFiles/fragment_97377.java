@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE, 
                isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class MyObject {

    private String foo;

    @JsonProperty("bar")
    private String bar;

    private boolean fubar;

    public MyObject(String foo, String bar, boolean fubar) {
        this.foo = foo;
        this.bar = bar;
        this.fubar = fubar;
    }

    public String getFoo() {
        return foo;
    }

    public String getBar() {
        return bar;
    }

    public boolean isFubar() {
        return fubar;
    }

}