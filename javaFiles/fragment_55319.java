static double getSolution1(int n) {
    List<Double> w = new ArrayList<Double>();
    w.add(-1d);
    for (int i = 0; i < n; i++) {
        double d = w.get(i) + ((2 / 3 * n) * Math.cos(w.get(i)));
        w.add(d);
    }
    return w.get(n);
}