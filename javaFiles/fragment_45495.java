public static void isGraph (int []a, int n) {
    int k = 0;
    for(int i=0; i< n; i++) {
        k += a[i] & 1;
    }
    if(k%2 == 0)
        System.out.println("Yes");
    else
        System.out.println("No");

}