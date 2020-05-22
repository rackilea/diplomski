private static boolean checkPrime(int n) {
    int i = 2;
    while(i<=n/2){
        if(n%i++ == 0){
            return false;
        }
    }
    return true;
}