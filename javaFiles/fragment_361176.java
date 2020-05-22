public class Test {
    public void foo() {
        System.out.println("foo");
        if(true)return;
        System.out.println("foo");
    }
    public void bar() {
        System.out.println("bar");
        if(false)return;
        System.out.println("bar");
    }
}