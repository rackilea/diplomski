public int avg(int[][] matrix , int n , int x , int y){
     int sum = 0;

     //the number of pixels to go left and right from the center of
     //the nxn-matrix
     int nHelper = n / 2;

     //ensure the left upper corner of your matrix is in bounds
     int x_start = (x - nHelper < 0 ? 0 : x - nHelper);
     int y_start = (y - nHelper < 0 ? 0 : y - nHelper);

     //create sum of all elements in the nxn-matrix and in bounds of
     //the big matrix (assumption: the matrix is an array of columns
     int i , j;
     for(i = x_start ; i < x + nHelper + 1 && i < matrix.length ; i++)
          for(j = y_start ; j < y + nHelper + 1 && j < matrix[i].length ; j++)
                sum += matrix[i][j];

     //calculate the average
     return sum / ((i - x_start)  * (j - y_start));
}