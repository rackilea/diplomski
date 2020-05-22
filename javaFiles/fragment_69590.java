for (int i = 0; i < pyramid.length; i++) {
    for (int j = i; j < pyramid.length; j++) {
        pyramid[i][j] = i;
        pyramid[j][i] = i;
    }
}