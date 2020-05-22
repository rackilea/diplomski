public static void main(String[] args) throws Exception{
    double t1 = System.nanoTime();
    int n;
    // int []a;  //  Not necessary
    int t = Integer.parseInt(in.nextLine());
    while(t-- > 0) {
        n = in.nextInt();
        // a = new int[n];  // Not necessary
        int k = 0;
        int a;
        for(int i=0; i<n; i++) {
            a = in.nextInt();
            k += a & 1;
        }
        // isGraph(a,n);  // Not necessary
        if(k % 2 == 0)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    System.out.println(System.nanoTime() - t1);
}