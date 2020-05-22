import java.util.AddPackage;

class UsePackage implements AddPackage {
    public static final void main(String[] args) {
        new UsePackage().doSomething();
    }

    public void doSomething() {
        System.out.println("Hi");
    }
}