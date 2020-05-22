public void printNPrimes(int start, int n){
    if (start == n)
        return;
    if (isPrime(start))
        System.out.print(start);

    printNprimes(start + 1 , n );
}