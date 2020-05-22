public static void main(String... args) {
    long free1 = free();
    String[] two = new String[2];
    long free2 = free();
    String[] twenty = new String[20];
    long free3 = free();
    if (free3 == free1) System.err.println("You need to use -XX:-UseTLAB");
    System.out.println("String[2] took " + (free1 - free2) + " bytes and String[20] took " + (free2 - free3) + " bytes.");
}

private static long free() {
    return Runtime.getRuntime().freeMemory();
}