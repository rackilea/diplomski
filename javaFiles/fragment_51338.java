public static char[][] mirror(int width, int height, char[][] in) {
    char[][] out = new char[height][width];
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            out[i][width - j - 1] = in[i][j];
        }
    }
    return out;
}