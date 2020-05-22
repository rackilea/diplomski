class Base {
}
class Child extends Base {
}
class GrandChild extends Child {
}
public class Example {

    public static final void main(String[] args) {
        a(null);
    }

    public static void a(Base b) {
        System.out.println("Base");
    }

    public static void a(Child b) {
        System.out.println("Child");
    }

    public static void a(GrandChild b) {
        System.out.println("GrandChild");
    }
}