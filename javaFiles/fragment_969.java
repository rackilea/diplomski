public void Miltiply(){
    // position_new = multiply ( transformation (3x3) * transpose(3x1)  )
    int rows=3, columns=1;
    int transformation[][]={{1,2,3},{1,1,1},{2,2,2}};
    int transpose[][]={{1},{1},{1}};
    double multiply[][] = new double[rows][columns];
    double sum;

    for (int k = 0; k < transpose[0].length; k++) {
        for (int e = 0; e < transformation.length; e++) {
            sum = 0;
            for (int f = 0; f < transpose.length; f++) {
                sum = sum + transformation[e][f] * transpose[f][k];
            }
            multiply[e][k] = sum;
        }
    }
    System.out.println("Multiplied Matrix:-");
    for (int m = 0; m < rows; m++) {
        for (int n = 0; n < columns; n++)
            System.out.print(multiply[m][n] + "\t");
        System.out.print("\n");
    } 
}