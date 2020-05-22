private <V extends City, E extends WeightedEdge<V>> void printWeightedEdgePath(List<E> pathList, V srcVertex, V destVertex) {
    PrintVisitor printVisitor = new PrintVisitor();
    if (!pathList.isEmpty()) {
        Object[] atThisCity = new Object[]{srcVertex};
        System.out.printf("%s to %s:  %s", srcVertex, destVertex, srcVertex);
        pathList.stream().forEach(edge -> {
            printVisitor.accept(edge);
            System.out.printf(" --%2.2f-->", e.weight());
            atThisCity[0] = e.getOther((V)atThisCity[0]);
            printVisitor.accept(atThisCity);
        });
        System.out.println();
    } else {
        System.out.printf("%s to %s:  not connected\n", srcVertex, destVertex);
    }
    System.out.println();
}