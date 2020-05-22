// declare with a large size
double data[][] = new double[80][80];

public TestMatrix(int rows, int cols, double[] data) {
    super();
    this.rows = rows;
    this.cols = cols;
    for (int i = 0, k = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            this.data[i][j] = data[k++];
        }
    }
}