public boolean checkNum(long num) {

    long n = num;
    long sum = 0;

    // find the number of digits
    int power = (int) Math.floor(Math.log10(n == 0 ? 1 : n)) + 1;

    while (n != 0) {
        int digit = (int) n % 10;
        sum += Math.pow(digit, power);
        n /= 10;
    }

    return sum == num;

}