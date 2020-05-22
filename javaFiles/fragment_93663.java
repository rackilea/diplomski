public Point FindElement(int[][] matrix, int number) {
    Point p = new Point(); // holds two integers and represents 
                           // a position in the matrix.
    int found = -1;
    for(int i = 0; i < N; i++) {
        found = binarySearch(matrix[i], number, 0, N);
        if(found != -1) { 
           p.setX(i); 
           p.setY(found); 
           return p; 
        }
    }
    return null;
}