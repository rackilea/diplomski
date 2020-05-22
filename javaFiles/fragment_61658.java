public static long memoryUsed() {
    final Runtime rt = Runtime.getRuntime();
    return rt.totalMemory() - rt.freeMemory();
}

public static void main(String... args) {
    long before = memoryUsed();
    String[] arr = { };
    long after = memoryUsed();
    if(before == after) throw new AssertionError("you need to turn off the TLAB with -XX:-UseTLAB");
    System.out.printf("The String[] used %,d bytes of memory%n", (after - before));
}