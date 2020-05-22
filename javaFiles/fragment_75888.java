public static void main(String[] args) {
    final String point = ".";
    final int rows = 20;
    final int columns = 50;

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            System.out.print(point);
        }
        System.out.println();
    }
}