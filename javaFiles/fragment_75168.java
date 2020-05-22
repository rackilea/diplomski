public static void main(String args[]) {

    Scanner scan = new Scanner(System.in);
    System.out.println("Enter number of primes ");
    int x = scan.nextInt();
    long[] prime = primes(x).toArray();

    Arrays.stream(prime).forEach(value -> System.out.print(value + " " ));

}


private static LongStream primes(long max) {
    return LongStream.iterate(2, i -> i + 1)
            .filter(PrimeNumber::isPrime)
            .limit(max);
}

private static boolean isPrime(long x) {
    return LongStream.rangeClosed(2, (long)(Math.sqrt(x)))
            .allMatch(n -> x % n != 0);
}