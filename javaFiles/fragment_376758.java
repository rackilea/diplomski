public static void main(String[] args) {
    for (int j = 32; j < 122; j++) {
        System.out.print((char)j);
        if (j % 10 == 1) {
            System.out.println();
        }
    }
}