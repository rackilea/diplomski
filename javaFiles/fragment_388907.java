void printNumber(int n) {
    if (n < 10)
        System.out.println(n);
    else {
        printNumber(n / 10);
        System.out.println(n % 10);
    }
}