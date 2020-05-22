public class MutableInt {

    private int value;

    public MutableInt(int value) { this.value = value; }

    public void setValue(int value) { this.value = value; }
    public int  getValue() { return this.value; }
}