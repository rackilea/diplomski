private static double evaluate(int n){                        
    double terms[] = new double[n];
    double term = 1.0;
    terms[n - 1] = term;
    while (n > 1){            
        terms[n - 2] = term /= n;
        --n;
    }        
    double sum = 0.0;
    for (double t : terms){
        sum += t;
    }        
    return sum;        
}