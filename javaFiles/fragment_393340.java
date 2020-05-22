static class OtherClass {
    static {
        if (!STATIC4) {
            System.out.println("Set STATIC4 to true");
            STATIC4 = true;
        }
    }
}
public static boolean STATIC4 = false;