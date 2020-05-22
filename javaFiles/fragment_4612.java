static int onePercentIncrease(int num) {
    int r = (int) (num * 1.01);
    if (r < 100 && (int) (Math.random() * 100) < 1) {
        r += 1;
    }
    return r;
}