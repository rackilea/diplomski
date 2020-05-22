public class StaticTest {
    public static void main(String[] args) {
        SuperClass s = new SubClass();
        s.method();  // bad idea - calling static method via an object reference
    }

    public static class SuperClass {
        public static void method() {
            System.out.println("SuperMethod");
        }
    }

    public static class SubClass extends SuperClass {
        public static void method() {
            System.out.println("SubMethod");
        }
    }
}