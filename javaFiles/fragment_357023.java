public class A {
     private final String test;

    public A(String test) {
        this.test = test;
    }

    public String check() {
        return "checked " + this.test;
    }
}