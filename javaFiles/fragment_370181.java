for (int i = 1; i <= number; i++) {
    boolean prime = true;
    for (int j = 2; j < i; j++) {
        if (i % j == 0) {
            prime = false;
        }
    }
    if (prime){
        return i; //<-- this return will terminate nextPrim
    }
}