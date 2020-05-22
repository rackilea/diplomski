private  double euclideanDistance(double[] lab , double []lab1){
    double L = lab[0] - lab1[0];
    double A = lab[1] - lab1[1];
    double B = lab[2] - lab1[2];
    return Math.sqrt((L * L) +  (A * A) +  (B * B));    
}