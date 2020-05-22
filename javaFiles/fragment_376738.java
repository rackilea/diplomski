public class DemoApplication {

    public static void main(String[] args) {
        Class<?> superclassOfB = new B().getClass().getSuperclass();
        Class<?> superclassOfA = new A().getClass().getSuperclass();
        System.out.println(superclassOfB);
        System.out.println(superclassOfA);
    }

    static class A {

    }

    static class B extends A {

    }
}