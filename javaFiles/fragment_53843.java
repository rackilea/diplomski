int[][] array = ...;
List<List<Double>> outer = new Vector<List<Double>>();
for (int[] row : array) {
    List<Double> inner = new Vector<Double>();
    for (int i : row) {
        inner.add(Double.valueOf(i));
    }
    outer.add(inner);
}