private static final long DISTANCE_MATRIX_SCALE_FACTOR = 100000000000L;
   private static long[][] scaleCoordinatesForEuclidean(List<LatLng> destinations) {
    long[][] locations = new long[destinations.size()][destinations.size()];
    for (int i = 0; i < destinations.size(); i++) {
        long[] coordinate = {(long) (destinations.get(i).lat * DISTANCE_MATRIX_SCALE_FACTOR), (long) (destinations.get(i).lng * DISTANCE_MATRIX_SCALE_FACTOR)};
        locations[i] = coordinate;
    }
    return locations;
}