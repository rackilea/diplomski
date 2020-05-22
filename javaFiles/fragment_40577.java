private static int count = 0; // <- initializing

// rabbit is ok

public static void main(String[] args) {
    System.out.println("Index" + "\t" + "Value" + "\t" + "Count");
    for (int p = 1; p <= 15; p++) {
        System.out.println(p + "\t" + rabbit(p) + "\t" + count);
        count = 0; // <- resetting
    }
}