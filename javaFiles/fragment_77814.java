public static int indexOfMaxInRange (int[] x, int firstIndex) {
    int max = Integer.MIN_VALUE;
    int i=firstIndex; //note! initialize to min instead of 0
    int maxLocation = firstIndex;
    while(i < x.length) {
        if (x[i] > max) {
            max = x[i];
            maxLocation= i;

        }
        i++;
    }
    return maxLocation;
}