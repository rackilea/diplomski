public static int changeSign(int[] b) {
    int counter = 0;
    for (int i = 0; i < b.length - 1; i++) {
        if (b[i] * b[i + 1] < 0) {
            counter++;
        }
    }
    return counter;
}