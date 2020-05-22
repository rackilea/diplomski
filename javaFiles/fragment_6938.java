public class Holder<T> {
    private T _value;
    private Holder(T value) { _value = value; }
    public static of(T value) { return new Holder<T>(value); }
    public T getValue() { return _value; }
    public void setValue(T value) { _value = value; }
}

...

Holder<String> x = Holder.of("123");
Holder<String> y = Holder.of("456");
someMethod(x, y);
return x.getValue() + y.getValue();