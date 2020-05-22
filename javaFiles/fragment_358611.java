public double calculaParallelResistance() {
    double runningResistance = 0;

    //use size() instead of length, which doesn't exist in ArrayList
    for (int index = 0; index < resistor.size(); index++) {
        //also, iterate over each resistor's value, and to get it, 
        //use...err, get() method :)
        runningResistance +=  (1 / resistor.get(index));
    }
    return 1 / runningResistance;
}