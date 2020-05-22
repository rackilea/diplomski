int[] options = new int[]{3,4,5,6,7,8,9,10};
double[] weights = new double[]{ 0.85/3d, 0.85/3d, 0.85/3d,
                                 0.10/3d, 0.10/3d, 0.10/3d,
                                 0.05/2d, 0.05/2d };

NavigableMap<Double, Integer> map = new TreeMap<Double, Integer>();
double totalWeight = 0d;

for (int i = 0; i < weights.length; i++) {
    totalWeight += weights[i];
    map.put(totalWeight, options[i]);
}