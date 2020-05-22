public static void main(final String[] args) {
    for (int i = 1; i <= 4; i++) {
        for (int j = 1; j <= i; j++) {
            System.out.print(j * j + " ");
        }
        System.out.println();
    }
}