static int pow(int base, int power) {
    int result = 1;
    for (int i = 0; i < power; i++)
        result *= base;
    return result;
}

private static void test(int base, int pow) {
    int x = pow(base, pow);
    if (pow != log(x, base))
        System.out.println(String.format("error at %d^%d", base, pow));
    if(pow!=0 && (pow-1) != log(x-1, base))
        System.out.println(String.format("error at %d^%d-1", base, pow));
}

public static void main(String[] args) {
    for (int base = 2; base < 500; base++) {
        int maxPow = (int) (Math.log(Integer.MAX_VALUE) / Math.log(base));
        for (int pow = 0; pow <= maxPow; pow++) {
            test(base, pow);
        }
    }
}