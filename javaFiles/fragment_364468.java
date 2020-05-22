int[] binarySearch(int[][] data, int from, int to, int[] value) {
    int trial = (from + to) / 2;
    if (from >= to)
        return new int[]{};
    int compare = compareTo(data[trial], value);
    if (compare < 0)
        return binarySearch(data, from, trial, value);
    else if (compare > 0)
        return binarySearch(data, trial, to, value);
    else 
        return data[trial];
}