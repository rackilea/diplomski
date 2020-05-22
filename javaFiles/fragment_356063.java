public Double displayLargest(double[][] l){
    Double maxValue = null;

    for (int x=0; x < l.length; x++) {
        for (int y=0; y < l[x].length; y++) {

            if (maxValue == null || maxValue < l[x][y]) {
                maxValue = l[x][y];
            }
        }
    }

    System.out.println("The largest value in the array is: " + maxValue);

    return maxValue;
}