public static void main(String args[]) {

    Scanner scan = new Scanner(System.in);
    System.out.println("Enter number of primes ");
    int x = scan.nextInt();
    List<Integer> primes = getPrimes(x);
    Integer[] primeArray = primes.toArray(new Integer[primes.size()]);
    for(int i :primes.toArray(primeArray)){ // you could just use for(int i :primes){ if you don't need array
        System.out.print(i + " ");
    }
}

private static List<Integer> getPrimes(int upperLimit) {

    ArrayList primes = new ArrayList();
    for (int i = 2; i < upperLimit; i++) {
        boolean isPrime = true;

        // Is it prime?
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime)
            primes.add(i);
    }
    return primes;
}