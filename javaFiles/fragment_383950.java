public double getSolution2 (double a, double b, double c){

    if (hasSolution){
        solution1= ((-1*b) - Math.sqrt(Math.pow(b,2)-(4*a*c))) / 2*a;
        return solution2;
    }
    return -1; // or throw an exception.
}