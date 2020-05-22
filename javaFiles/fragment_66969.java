public void rotate90(int n) {
    for (int i=0; i<n; i++) {
        for (int r=0; r<w; r++) {
            for (int c=0; c<h; c++) {
                imageMatrix[c][w-r-1] = imageMatrix[r][c];
            }
        }
    }