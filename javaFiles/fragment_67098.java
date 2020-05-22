public class Mirror<T> {
    private T value
    private Mirror(T value) {
        this.value = value;
    }

    public static Mirror<Integer> integerMirror(Integer value) {
        return new Mirror(value);
    } 

    public static Mirror<String> stringMirror(String value) {
        return new Mirror(value);
    } 

    public static Mirror<MagicValue> magicMirror(MagicValue value) {
        return new Mirror(value);
    } 
}