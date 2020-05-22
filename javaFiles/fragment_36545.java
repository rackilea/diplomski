public void convolve() {
    int[][] convolved = new int[image.length][image[0].length];
    double invScale = 1.0 / weight();

    for (int r = 0; r < convolved.length - weights.length - 1; r++) {
        for (int c = 0; c < convolved[r].length - weights.length - 1; c++) {
            int rsum = 0, gsum = 0, bsum = 0;
            for (int i = 0; i < weights.length; i++) {
                for (int j = 0; j < weights[i].length; j++) {
                    int pixel = image[r + i][c + j];
                    int w = weights[i][j];
                    rsum += ((pixel >> 16) & 0xFF) * w;
                    gsum += ((pixel >> 8) & 0xFF) * w;
                    bsum += (pixel & 0xFF) * w;
                }
            }
            rsum = (int)(rsum * invScale);
            gsum = (int)(gsum * invScale);
            bsum = (int)(bsum * invScale);
            convolved[r][c] = bsum | (gsum << 8) | (rsum << 16) | (0xFF << 24);
        }
    }

    this.convolved = convolved;
}