static boolean erPrimtall(int values) {
    boolean isPrime = true;
    for(int i = 2; i < values; i++) {
        if(values % i == 0) {
            isPrime= false;
            break;
        }
    }
    return isPrime;
}