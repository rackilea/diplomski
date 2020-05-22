public double [] allCalcs(){
    // your code goes here
    double total [] = new double [3];
    total[0] = (countZero * 1.0 / number.length) * 100;
    total[1] = (countPos * 1.0 / number.length) * 100;
    total[2] = (countNeg * 1.0 / number.length) * 100;
    return total;
}