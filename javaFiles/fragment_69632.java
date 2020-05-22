public static int triangular(int n){
    if(n <= 0) return 0;

    for (int i = 0; i < n; i++) {
        System.out.print("* ");
    }
    System.out.println();

    return n + triangular(n - 1);
}