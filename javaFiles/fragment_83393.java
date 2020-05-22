public static long pow(int x, int n) {
    long p = x;
    System.out.println("Pow: "+x+","+n);
    for (int i = 1; i < n; i++) {
        p *= x;
        System.out.println(p);
    }
    return p;
}