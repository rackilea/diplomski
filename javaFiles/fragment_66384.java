public class TestBean {
    private int baz;
    private char[] phleem;

    public String getFoo() {
        return new String(phleem);
    }
    public void setFoo(final String foo) {
        this.phleem = foo.toCharArray();
    }
    public long getBar() {
        return baz;
    }
    public void setBar(final long bar) {
        this.baz = (int) bar;
    }
}