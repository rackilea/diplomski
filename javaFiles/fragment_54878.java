public class MyFactory {
    private final int commonValue;
    public MyFactory (int commonValue) { this.commonValue = commonValue; }

    public MyInterface myObject(int value) {
        return new MyObject(value, commonValue);
    }

    public MyInterface yourObject(String str) {
        return new YourObject(str, commonValue);
    }
}