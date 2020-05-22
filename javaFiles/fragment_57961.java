public class Foo {

    private String bar;
    private boolean barSet = false;

    public String getBar() {
       return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
        this.barSet = true;
    }

}