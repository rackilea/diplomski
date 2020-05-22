int [][] getResults(int numPositions, int low, int high) {
    int numValues = high - low + 1;
    int numResults = (int) Math.pow(numValues, numPositions);
    int results[][] = new int [numResults][numPositions];
    for (int i = 0; i < numResults; i++) {
        int result[] = results[i];
        int n = i;
        for (int j = numPositions-1; j >= 0; j--) {
            result[j] = low + n % numValues;
            n /= numValues;
        }
    }
    return results; 
}