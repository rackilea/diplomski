public static void main(String[] args) {
    int size = 5;
    for (int i = 0; i < size; i++) {
        int width = Math.min(i, size - 1 - i) * 2 + 1;
        for (int j = 0; j < width; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
}