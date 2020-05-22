public interface MyInterface {
    MyInterface clone();
    void doSomething();
}

public class MyClass implements MyInterface {

    @Override
    public void doSomething() {
        System.out.println("Hi");
    }

    @Override
    public MyInterface clone() {
        return new MyClass();
    }

    public static void main(String[] args) {
        MyInterface mi = new MyClass();
        MyInterface mi2 = mi.clone();
        mi2.doSomething();
    }

}