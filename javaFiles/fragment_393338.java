static {
    if (!ThisClass.STATIC2) {
        System.out.println("Set STATIC2 to true");
        ThisClass.STATIC2 = true;
    }
}
public static boolean STATIC2 = false;