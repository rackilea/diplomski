import javax.validation.constraints.Min;

public class Foo {

    private int bar;

    @Min(0)
    public int getBar() {
        return bar;
    }

    public void setBar(int bar) {
        this.bar = bar;
    }
}