public static int[] calculateFactors(int n) {
    int[] array = new int[n];
    for(int i = 0; i <= n; i++) {
        if(n % i == 0) {
            return array[i];
        }
    }
}