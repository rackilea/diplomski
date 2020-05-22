public abstract class MyClass<T> {
    public abstract void setThings(List<T> things);
}

public class SubClass extends MyClass<String> {
    private List<String> things;

    public void setThings(List<String> things) {
        this.things = things;
    }
}