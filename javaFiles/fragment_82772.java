public static void main(String[] args) throws Exception {
    String str = "123456789";
    int size = 3;

    int[][] matrix = new int[size][size];
    {
        int index = 0;
        for (int diagonal = 0; diagonal < size * 2 - 1; diagonal++) {
            int row = diagonal;
            int column = 0;
            while (row >= 0) {
                if (row < size && column < size) {
                    matrix[size - row - 1][column] = Character.getNumericValue(str.charAt(index++));
                }
                row--;
                column++;
            }
        }
    }
}