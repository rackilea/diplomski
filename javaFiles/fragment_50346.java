public class Test {

    private static void test(Object object) {
        System.out.println("Object method");
    }

    private static void test(Integer integer) {
        System.out.println("Integer method");
    }

    public static void main(String[] args) {
        Object object = Integer.valueOf(0);
        test(object);
    }

}