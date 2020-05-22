public static int[] primes(BitSet composite) {
    int size = composite.size() - 2 - composite.cardinality();
    int[] primes = new int[size];
    int index = 0;
    for (int i = 2; i < composite.size(); i++) {
        if (!composite.get(i)) primes[index++] = i;
    }
    return primes;
}