while (n > 0) {       
    if(n % 2 == 1) {
        multiplications++;
        result *= x;
        n--;
    }
    multiplications++;
    x *= x; // shouldn't that be result *= result?
    n /= 2;
}
multiplications -= 2;