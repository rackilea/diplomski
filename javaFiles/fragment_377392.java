public static int[] multiple(int[] a, int n){
    int[] x = new int[100];
    for(int i = 0; i < a.length; i++) {
        x[i] = randomInt(0, 100) * n; // Here
    }
    return x;
}