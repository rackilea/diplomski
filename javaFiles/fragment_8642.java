public class Main {
    private static final ThreadLocal<Integer> CURRENT_ID = new ThreadLocal<>(1);

    private void method1() {
        CURRENT_ID.set(100);
        method2();
    }

    private void method2() {
        System.out.println("ID: " + CURRENT_ID.get());
    }
}