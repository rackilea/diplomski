public static int [] alternate(int [] a, int [] b){

    int[] c = new int[a.length + b.length];
    int counter = 0;
    for (int i = 0; i < a.length; i++){

        c[counter++] = a[i];
        c[counter++] = b[i];
        // or
        //c[2 * i] = a[i];
        //c[2 * i + 1] = b[i];
    }

    return c; 
}