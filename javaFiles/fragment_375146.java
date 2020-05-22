static long memTaken() {
    final Runtime rt = Runtime.getRuntime();
    return rt.totalMemory() - rt.freeMemory();
}

public static void main(String... args) {
    long used1 = memTaken();
    Float i = new Float(0);
    long used2 = memTaken();
    System.out.println("new Float(0) used "+(used2 - used1)+" bytes.");
}