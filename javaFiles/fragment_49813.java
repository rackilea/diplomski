public int[][] replace(int[][] numbers, int n) {
    int[][] result=new int[n][n];
    int ref = numbers[0][0];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (numbers[i][j]==ref) {
                boolean isAdj=false;
                if(i>0) isAdj=isAdj || numbers[i-1][j]==ref;
                if(i<n-1) isAdj=isAdj || numbers[i+1][j]==ref;
                if(j>0) isAdj=isAdj || numbers[i][j-1]==ref;
                if(j<n-1) isAdj=isAdj || numbers[i][j+1]==ref;
                if(isAdj) result[i][j]=1;
            }
        }
    }
    return result;
}