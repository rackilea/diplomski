public static boolean isPrime(int num) {
    long i;
    for (i=2; i <= Math.sqrt(num) ; i++){
        long n = num%i;
        if (n == 0){
            return false;//found a divisor : not prime
        } 
    }
    //went through all the way to sqrt(num), and found no divisor: prime!
    return true;
}