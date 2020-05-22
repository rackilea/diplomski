public static void main(String... args) {
    for (int i = 0; i < 10; i++) {
        long used1 = memoryUsed();
        new Object();
        long used2 = memoryUsed();
        System.out.println(used2 - used1);
    }
}

public static long memoryUsed() {
    return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
}