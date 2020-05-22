private static int[] genrate(int x, int y) {
    int a[] = new int[y];
    for(int i=1; i<y; i++){
        int val = (i*(i+1))/2;
        a[i] = val;
    }           
    return a;
}