public static boolean isEmirp(int x){

    int reverseOfX = reverse(x);
    return x != reverseOfX && isPrime(x) && isPrime(reverseOfX);

}