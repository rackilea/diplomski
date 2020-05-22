List<List<Double>> list = new ArrayList<>();
for (double[] doubles : DDs) {
    List<Double> listDoubles = new ArrayList<>(); //Cannot use Arrays.asList() because that will return List<double[]> with a single element
    for (double innerDouble : doubles) {
        listDoubles.add(innerDouble);
    }
    list.add(listDoubles);
}