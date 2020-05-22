public static int difference(int num1, int num2) {
    int count = 0;
    for (int i = 0; i < 32; i++) {
        if (((num1 >> i) & 1) != ((num2 >> i) & 1)) count++;
    }
    return count;
}