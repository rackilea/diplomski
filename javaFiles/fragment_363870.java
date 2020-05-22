String[][] keyMatrix = read_matrix(); //reads the first matrix from input 
int rows = keyMatrix.length;
int cols = keyMatrix[0].length;
double[][] sumMatrix= new double[rows][cols];

do {
    for(int i = 0;i<rows;i++){
       for(int j=0;j<cols;j++){
          sumMatrix[i][j] +=  Double.valueOf(keyMatrix[i][j]);
       }
    }
} while (null != ( keyMatrix=read_matrix()  ));