public static void putboard() {
    System.out.println("\n\nSolution " + (++s));
    for (int y = 0; y < 8; y++) {
        for (int x = 0; x < 8; x++) {
            if (b[y] == x)
                System.out.print("|Q");
            else
                System.out.print("|_");
        }
        System.out.println("|");
    }
}