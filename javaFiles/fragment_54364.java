Arrays.sort(ratio, new Comparator<double[]>() {
    @Override
    public double compare(double[] o1, double[] o2) {
        return Double.compare(o1[0], o2[0]);
    }
});