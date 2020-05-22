public class FooDemo {
    public static void main(String[] args) {
        Foo foo1 = new Foo();
        Foo foo2 = new Foo();
        foo1.setData(3);
        foo2.setData(4);
        System.out.println(foo1.getData());
        System.out.println(foo2.getData());
    }
}