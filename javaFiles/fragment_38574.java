private static double evaluate_fast(int n){        
    double sum = 1.0;
    double term = 1.0;
    while (n > 1){
        double old_sum = sum;
        sum += term /= n--;
        if (sum == old_sum){
            // precision exhausted for the type
            break;
        }
    }                
    return sum;        
}