HarmonicCurveFitter curveFit = new HarmonicCurveFitter.create();
List<WeightedObservedPoint> points = new ArrayList<WeightedObservedPoint>();
for (int i=0; i < half_cycle.length; i++) {
    points.add(new WeightedObservedPoint(1.0, i, half_cycle[i]));
}
double[] vals = curveFit.fit(points);