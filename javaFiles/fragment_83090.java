public static double sqrtSquares(double []A) {
    double sum = 0;
    for(int i = 0; i<A.length; i++) {
        if(A[i] < 0 ) {
            A[i] = 0;
        }
        sum += A[i]*A[i];    // calculate the running sum of squares
    }
    return Math.sqrt(sum);   // calculate the square root of the sum of squares
}