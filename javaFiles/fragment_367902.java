public class A {
    private TheClass<Object> instance;

    public A(TheClass<Object> instance) {
        this.instance = instance;
    }

    public void do(Object target) {
        instance.theMethod(target); 
    }
}