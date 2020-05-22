double[] toArray(Collection<Double> collection) {
    double[] arr = new double[collection.size()];
    int i = 0;
    for (Double d : collection) {
        arr[i++] = d;
    }
    return arr;
}