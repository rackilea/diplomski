public static void main(String[] args) throws Exception {
    int[] int1 = { 2, 3, 4, 6, 11, 13, 17, 99 };

    int square = 0;
    int result = 0;

    for (int i = 0; i < int1.length; i++) {
        if (isPrime(int1[i])) {
            System.out.println(int1[i]);
            square = int1[i] * int1[i];
            result += square;
        }

    }

    System.out.println(result);
}