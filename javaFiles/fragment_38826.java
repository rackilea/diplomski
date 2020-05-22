public class MyFactory {
    static SomeInterface make() {
        // MyFactory can see MyImplementation
        return new MyImplementation();
    }
}