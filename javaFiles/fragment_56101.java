public int maxOfAll(int a, int b, int c, int d) {
    //Look for the maximum of 4 variable
    int temp1max = Math.max( a, b );
    int temp2max = Math.max( temp1max, c );
    int temp3 = Math.max( temp2max, d );
    return temp3;
}

public int minOfAll (int a, int b, int c, int d) {
    //Look for the minimum of 4 variable
    int temp1 = Math.min( a, b );
    int temp2 = Math.min( temp1, c );
    int temp3 = Math.min( temp2, d );
    return temp3;
}