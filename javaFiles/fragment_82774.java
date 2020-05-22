public static Assignment findWithVehicleRoutingProblem(List<LatLng> destinations, int numOfVehicles) {
    long[][] distanceMatrix = RoutUtils.computeEuclideanDistanceMatrix(RoutUtils.scaleCoordinatesForEuclidean(destinations));
    RoutingIndexManager manager = new RoutingIndexManager(distanceMatrix.length, numOfVehicles, 0);

    RoutingModel routing = new RoutingModel(manager);
    final int transitCallbackIndex = routing.registerTransitCallback((long fromIndex, long toIndex) -> {
        int fromNode = manager.indexToNode(fromIndex);
        int toNode = manager.indexToNode(toIndex);
        return distanceMatrix[fromNode][toNode];
    });

    routing.setArcCostEvaluatorOfAllVehicles(transitCallbackIndex);

    routing.addDimension(transitCallbackIndex, 0, 3000,
            true, 
            "Distance");
    RoutingDimension distanceDimension = routing.getMutableDimension("Distance");
    distanceDimension.setGlobalSpanCostCoefficient(100);

    RoutingSearchParameters searchParameters = main.defaultRoutingSearchParameters()
            .toBuilder()
            .setFirstSolutionStrategy(FirstSolutionStrategy.Value.PATH_CHEAPEST_ARC)
            .build();

    return routing.solveWithParameters(searchParameters);
}