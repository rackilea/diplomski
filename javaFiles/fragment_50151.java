public static int calculateFactorial(int nr) {
    int factorialTotal = 1;
    for (int i = nr; i > 0; i--)
        factorialTotal *= i; //i *= j; is the same as i = i * j;
    return factorialTotal;
}