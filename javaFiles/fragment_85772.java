public class StringOrInteger {
    final String s;
    final Integer i;
    public StringOrInteger(String s) {
        this.s = s;
        this.i = null;
    }
    public StringOrInteger(Integer i) {
        this.s = null;
        this.i = i;
    }
    public boolean isString() {
        return this.s != null;
    }
}