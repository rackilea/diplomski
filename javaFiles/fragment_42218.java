public class MyImplementation implements MyInterface {
    public MyImplementation(String name) {
    }
    @Override
    public MyInterface getInstance() { // static is not allowed here
        return getInstanceImpl();
    }
    public static getInstanceImpl() {
        return new MyImplementation(name)
    }
}