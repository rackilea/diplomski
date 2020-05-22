public class IntMatrix {
    private int rows;
    private int cols;
    private int[] data;

    /**
     * Allocate a matrix with the indicated initial dimensions.
     * @param cols The column (horizontal or x) dimension for the matrix
     * @param rows The row (vertical or y) dimension for the matrix
     */
    public IntMatrix(int cols, int rows) {
        this.rows = rows;
        this.cols = cols;
        data = new int[cols * rows];
    }

    /**
     * Calculates the index of the indicated row and column for
     * a matrix with the indicated width. This uses row-major ordering
     * of the matrix elements.
     * <p>
     * Note that this is a static method so that it can be used independent
     * of any particular data instance.
     * @param col The column index of the desired element
     * @param row The row index of the desired element
     * @param width The width of the matrix
     */
    private static int getIndex(int col, int row, int width) {
        return row * width + col;
    }

    public int get(int col, int row) {
        return data[getIndex(col, row, cols)];
    }

    public void set(int col, int row, int value) {
        data[getIndex(col, row, cols)] = value;
    }

    /**
     * Resizes the matrix. The values in the current matrix are placed
     * at the top-left corner of the new matrix. In each dimension, if
     * the new size is smaller than the current size, the data are
     * truncated; if the new size is larger, the remainder of the values
     * are set to 0.
     * @param cols The new column (horizontal) dimension for the matrix
     * @param rows The new row (vertical) dimension for the matrix
     */
    public void resize(int cols, int rows) {
        int [] newData = new int[cols * rows];
        int colsToCopy = Math.min(cols, this.cols);
        int rowsToCopy = Math.min(rows, this.rows);
        for (int i = 0; i < rowsToCopy; ++i) {
            int oldRowStart = getIndex(0, i, this.cols);
            int newRowStart = getIndex(0, i, cols);
            System.arraycopy(data, oldRowStart, newData, newRowStart,
                colsToCopy
            );
        }
        data = newData;
    }

    . . .
}