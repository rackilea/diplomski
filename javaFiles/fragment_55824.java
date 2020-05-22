class Stroke {
    List<Point2D> points;
    double[][] toArray() {
        return points.stream()
                // this part you already knew how to do
                .map(p -> new double[]{p.getX(), p.getY(), 0.0})
                .toArray(double[][]::new);
    }   
}
class Matrix {
    List<Stroke> stroke;
    double[][] toArray() {
        return stroke.stream()
                .map(Stroke::toArray)
                // next we will reduce the stream of double[][] to one...
                .reduce(new double[][]{}, (a,b) -> {
                    // ...by concatenating each double[][] with its neighbor
                    return Stream.concat(Arrays.stream(a), Arrays.stream(b))
                            .toArray(double[][]::new);
                });
    }   
}