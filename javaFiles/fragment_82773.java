/// @brief Compute Euclidean distance matrix from locations array.
/// @details It uses an array of locations and computes
/// the Euclidean distance between any two locations.
private static long[][] computeEuclideanDistanceMatrix(long[][] locations) {
    // Calculate distance matrix using Euclidean distance.
    long[][] distanceMatrix = new long[locations.length][locations.length];
    for (int fromNode = 0; fromNode < locations.length; ++fromNode) {
        for (int toNode = 0; toNode < locations.length; ++toNode) {
            if (fromNode == toNode) {
                distanceMatrix[fromNode][toNode] = 0;
            } else {
                distanceMatrix[fromNode][toNode] =
                        (long) Math.hypot(locations[toNode][0] - locations[fromNode][0],
                                locations[toNode][1] - locations[fromNode][1]);
            }
        }
    }
    return distanceMatrix;
}