class MyTest {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("object is unreachable..");
    }
}
// In some other class
public static void main(String[] args) {
        MyTest o1 = new MyTest();
        MyTest o2 = new MyTest();
        System.gc();
        o1 = null;
        System.gc();
        System.out.println("hello");
}
O/P:
hello
object is unreachable..