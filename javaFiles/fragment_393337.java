public static boolean STATIC1 = false;
static {
    if (!STATIC1) {
        System.out.println("Set STATIC1 to true");
        STATIC1 = true;
    }
}