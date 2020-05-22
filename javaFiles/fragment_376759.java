public static void main(String[] args) {
    // Increment row/counter by 10
    for (int row = 32; row < 122; row += 10) {
        for (int col = 0; col < 10; col++) {
            System.out.print((char)(row + col));
        }
        System.out.println();
    }
}