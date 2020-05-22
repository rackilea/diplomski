public static void main(final String[] args) {
    for (int i = 1; i <= 4; i++) {
        for (int j = 1; j <= i; j++) {
            int exp = (int) Math.pow(j, i);
            System.out.print(exp);
        }
        System.out.println();
    }
}