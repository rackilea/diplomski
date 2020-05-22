public class MyClass implements MyInterface {

    @Override
    public void method1() {
        System.out.println("foo1");
    }

    @Override
    public void method2() {
        System.out.println("foo2");
    }

    @Override
    public void methodN() {
        System.out.println("fooN");
    }

    public static void main(String[] args) {
        MyClass wrapped = new MyClass();
        wrapped.method1();
        wrapped.method2();
        MyInterface wrapper = WrapperClass.wrap(wrapped);
        wrapper.method1();
        wrapper.method2();
    }

}