public class MyClass {

    MyClass okMethod() {
        return this;
    }

    MyClass explodingMethod() {
        throw new RuntimeException();  // line 10
    }

    public static void main(String[] args) {
        new MyClass()
                .okMethod()
                .explodingMethod() // line 16
                .okMethod();
    }
}