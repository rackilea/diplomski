@Override
public void onPreviewFrame(Mat image) {
    if (image == null || image.empty() == true) return;

    int w = image.cols(); //640 columns
    int h = image.rows(); //480 rows

    double[][][] array15x15 = new double[15][15][3];

    for (int row = 0; row < 15; row++) {
        for (int col = 0; col < 15; col++) {
            double[] p = image.get(w/2 + row, h/2 + col);
            if (p == null || p.length < 3) return;
            else {
                array15x15[row][col] = p;
            }
        }
    }
}