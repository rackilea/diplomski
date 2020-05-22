public static void main(String[] args) {
    // Entry Mechanism
    Scanner input = new Scanner(System.in);

    // Variables
    int n1, biggestPrime;

    System.out.print("Number: ");
    n1 = input.nextInt();

    biggestPrime = biggestPrime(n1);

}

public static int biggestPrime(int n1) {
    int biggestPrime = 0;
    int num_max = 100000;

    if (n1 < 0) {
        return 0;
    }
    else {
        for (int i = n1; i< num_max; i++) {
            for (int j = 2; j < Math.sqrt(i); j++) {
                System.out.println(j + " " + i);
                if (i==j) {
                    biggestPrime = i;
                    // break:
                    j = num_max;
                    i = num_max;
                }
                if (i % j == 0) {
                    break;
                }                      
            }
        }
    }
    return biggestPrime;
}