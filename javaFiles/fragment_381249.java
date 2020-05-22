public class DelayedModificationField<T> {
    private T field;
    private T newValue;
    public T get() { return field;}
    public delayedSet(T value) {
        if (newValue != null) throw new ConcurrentModificationException("error");
        newValue = value;
    }
    public void performSet() {
        field = newValue;
        newValue = null;
    }

public ExampleClass {
    private DelayedModificationField<String> myField = new DelayedModificationField<String>();
    public void setMyField(String s) { myField.delayedSet(s);}
    public String getMyField() { return myField.get();}
    public void performSet() { myField.performSet();}
}