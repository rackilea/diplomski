public static int largest(int num1, int num2, int num3) {
    if (num1 == num2 && num2 == num3) {
        return -1;
    } else {
        return Math.max(Math.max(num1, num2), num3);
    }
}