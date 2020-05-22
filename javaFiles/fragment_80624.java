public interface Factory {
    public Object create();
}
public class MyClass {
    public static class MyFactory implements Factory {
        @Override
        public Object create() {
            return new MyClass();
        }
    }
    private MyClass() {
    }
}