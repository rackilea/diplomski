public static int factorial (int n){
    int result = 1;
    for (int i = 2; i <= n; i++) { // <-- n, not 100.also, x*1=x
        result *= i;
    }
    return result;
}