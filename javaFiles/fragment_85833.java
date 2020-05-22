public static void main(String args[]) {
    int t, n;
    Scanner sc = new Scanner(System.in);
    t = sc.nextInt();
    while (t-- > 0) {
        n = sc.nextInt();
        long[] ar = new long[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextLong();
        }
        System.out.println(invCount(ar));
    }
}