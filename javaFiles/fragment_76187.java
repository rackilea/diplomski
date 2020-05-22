public class VarargsTest {

    public static void a(int... s) {
        System.out.println("int varargs invoked.");
    }

    public static void a(short... s) {
        System.out.println("short varargs invoked.");
    }

    public static void a(long... s) {
        System.out.println("long varargs invoked.");
    }

    public static void a(byte... s) {
        System.out.println("byte varargs invoked.");
    }

    public static void main(String... args) {
        a();
    }
}