public static double linear(double[] ar) {
    double max = Double.NEGATIVE_INFINITY;
    double min = Double.POSITIVE_INFINITY;

    for(double elem: ar){
        if(min > elem) {min = elem;}
        if(max < elem) {max = elem;}
    }

    return Math.abs(max-min); 
}