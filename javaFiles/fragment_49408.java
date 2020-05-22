public static double distance() {

    for (int i = 0; i < GetFile.testMatrix.length;) {

        double[] distances = new double[4000];
        for (int j = 0; j < GetFile.trainingMatrix.length; j++) {
            distances[j] = EuclideanDistance.findED(GetFile.trainingMatrix[j], GetFile.testMatrix[i]);
        }

        return getMinDistance(distances);
    }
    return 0;

}


static double getMinDistance(double[] distances) {
    double minDistance = Double.MAX_VALUE;
    for (double distance : distances) {
        minDistance = Math.min(distance, minDistance);
    }
    return minDistance;
}