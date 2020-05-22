private static int x = 0;
static int method(int r) {
    int temp = x + r;
    if (temp < 10) {
        x = temp;
    }
    return x;
}