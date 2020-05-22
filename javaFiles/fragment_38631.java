private int dp_optimized(int[] a) {
    int[] col1 = new int[a.length+1];
    int[] col2 = new int[a.length+1];
    for(int i = a.length-1; i>0; i--) {
        for(int p = i-1; p>=0; p--) {
            col1[p] = col2[p];
            if(a[i] > a[p]) 
                col1[p] = Math.max(col1[p], 1+col2[i]);
        }
        for(int p=0; p< col1.length; p++){
            col2[p] = col1[p];
        }
    }
    return col1[0];
}