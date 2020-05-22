public static int[][] group(int groups, int size){
    int[][] output = new int[groups][size];
    for(int value = 0; value < (groups*size); value++) {
        output[value % groups][(int)value/groups] = value;
    }
    return output;
}