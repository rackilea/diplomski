public static void main(String[] args) {
    int[][] boo = new int[50][];


    for(int i = 0; i < boo.length; i++){
        boo[i] = new int[i+1]; // initialize the i'th row to have i+1 elements
        for(int k = 0; k< boo[i].length; k++){
            boo[i][k] = ...
        }
    }
    System.out.println(Arrays.deepToString(boo)); // this change is required to print 2D array
}