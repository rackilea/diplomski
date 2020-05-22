public static ArrayList<Double> getEma(ArrayList<Double> x, int frame) {
    ArrayList<Double> m = new ArrayList<Double>();
    double w = (2 / ((double) frame + 1));

    m.add(x.get(0));

    for (int i=1; i < x.size(); i++) {
        double value = (w * (x.get(i) - m.get(i-1))) + m.get(i-1);
        m.add(value);
    }

    return m;
}