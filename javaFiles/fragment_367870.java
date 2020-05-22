...
double[] timeFeed = new double[timeVals.size()];
double[] priceFeed = new double[priceVals.size()];

for(int x = 0; x < timeVals.size(); x++) {
    timeFeed[x] = timeValsArray[x].doubleValue();
    priceFeed[x] = priceValsArray[x].doubleValue();
}
...