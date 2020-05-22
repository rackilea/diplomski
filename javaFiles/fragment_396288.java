DataSet<Point> points = env.readCsv(...);

DataSet<Centroid> centroids = ... ; // some computation

points.map(new RichMapFunction<Point, Integer>() {

    private List<Centroid> centroids;

    @Override
    public void open(Configuration parameters) {
        this.centroids = getRuntimeContext().getBroadcastVariable("centroids");
    }

    @Override
    public Integer map(Point p) {
        return selectCentroid(centroids, p);
    }

}).withBroadcastSet("centroids", centroids);