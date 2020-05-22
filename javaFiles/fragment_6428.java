public static int reverse(int num) {
    int input = num;
    int num1 = 0;

    while (input>0) {
        num1 = num1 * 10;
        num1 = num1 + input%10;
        input = input / 10;
    }
    return num1;
}