class DouglasPeucker {
    private List<Point[]> steps = new ArrayList<>();

    public Point[] compute(Point[] points) {
        steps.add(points.clone());
        // perform normal recursive steps
    }

    public void printSteps() {
        for (Point[] points: steps) {
            ...
        }
    }
}