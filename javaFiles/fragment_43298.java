public class Base {
    public Base() { }
    public void methodA() {
        System.out.println("Base: methodA");
        // Call the derived method
        methodB();
        // Call the base method
        methodB_impl();
    }
    public final void methodB_impl() {
        System.out.println("Base: methodB");
    }
    public void methodB() {
        methodB_impl();
    }
}