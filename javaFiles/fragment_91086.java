public static void main(String[] args) {
    xor(new boolean[] { true, false }); // will call the primitive xor
    xor(new Boolean[] { Boolean.TRUE, Boolean.FALSE }); // will call the non-primitive xor
}

private static Boolean xor(Boolean... booleans) {
    System.out.println("Boolean...");
    return Boolean.TRUE;
}

private static boolean xor(boolean... booleans) {
    System.out.println("boolean...");
    return true;
}