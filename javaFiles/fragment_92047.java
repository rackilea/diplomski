public static int GetMaxDensity(int N, int[] X, int[] Y) {
    int rangeStart = Integer.MAX_VALUE;
    int rangeEnd = Integer.MIN_VALUE;
    for(int i=0; i<N; i++) {
        if (X[i] < rangeStart) rangeStart = X[i];
        if (Y[i] > rangeEnd) rangeEnd = Y[i];
    } 
    int rangeSize = rangeEnd - rangeStart + 1;
    int[] histogram = new int[rangeSize];
    for (int t = 0; t < rangeSize; t++) histogram[t] = 0;
    for (int i = 0; i < N; i++) {
        histogram[X[i]-rangeStart]++;
        histogram[Y[i]-rangeStart]--;
    }
    int maxCount = 0;
    int count = 0;
    for (int t = 0; t < rangeSize; t++) {
        count += histogram[t];
        if (count > maxCount) maxCount = count;
    }
    return maxCount;        
}