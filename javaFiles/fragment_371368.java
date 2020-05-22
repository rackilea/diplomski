public static void countToBy(int n, int m) {
   int store = n - m; 
    if(store > 0) {
        countToBy(store, m );
        System.out.print(", ");
    }
    System.out.print(n);
}