Set<Integer> primes = new TreeSet<>();

//generate all numbers up to n and add them to the set
for (int i = 2; i < n; i++) {
    primes.add(i);
}

//for numbers up to root n
for (int f = 2; f <= Math.sqrt(n); f++){
    Iterator<Integer> iter = primes.iterator();