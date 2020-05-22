long sum = 0;
int[][] fastArray = new int[2][10000];
for (int i=0; i<fastArray.length; ++i) {
    int[] subArray = fastArray[i];
    for (int j=0; j<subArray.length; ++j) {
        sum += subArray[j];
    }
}