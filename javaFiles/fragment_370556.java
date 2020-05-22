double[] allowedRangeEnds = {0,1,5,10,20,50,100,200,500,1000,2000,5000,10000};

//returns the smalles allowed rangeend which is > value
double getNextRangeEnd(double value){
    int i = 0;
    while(allowedRangeEnds[i] < value && i < allowedRangeEnds.length - 1){
        i++;
    }
    return allowedRangeEnds[i];
}