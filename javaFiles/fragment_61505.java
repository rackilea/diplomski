public class FindElement2DimArrayExample {
    private class Couple {
        private int row;
        private int col;

        public Couple(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public String toString() {
            return "[" + row + ", " + col + "]";
        }
    }

    public static void main(String[] args) {
        int[][] array = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(new FindElement2DimArrayExample().search(array, 5));
    }

    public Couple search(int[][] array, int element) {
        return searchRecursively(array, element, 0, 0);
    }

    public Couple searchRecursively(int[][] array, int element, int actualRow, int actualCol) {
        if (array.length <= actualRow) {
            return null;
        } else if (array[actualRow].length <= actualCol) {
            return searchRecursively(array, element, actualRow + 1, 0);
        } else if (array[actualRow][actualCol] == element) {
            return new Couple(actualRow, actualCol);
        } else {
            return searchRecursively(array, element, actualRow, actualCol + 1);
        }
    }
}