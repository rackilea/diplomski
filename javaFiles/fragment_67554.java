public class MyObject {
    @Override
    public int hashCode() {
        return 42;
    }

    public static void main(String[] args) {
        MyObject obj1 = new MyObject();
        MyObject obj2 = new MyObject(); // Ta-da!
    }
}