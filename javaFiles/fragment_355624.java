for (String source: destinations) {
    Set<DefaultWeightedEdge> edges = graph.outgoingEdgesOf(source);
    for (DefaultWeightedEdge edge : edges) {
        //String source = graph.getEdgeSource(edge);
        String target = graph.getEdgeTarget(edge);
        boolean comingBack = graph.containsEdge(target, source);
        if (comingBack && source.compareTo(target) > 0) {
            continue; // Skip B <-> A as already A <-> B.
        }
        String arrow = comingBack ? "<->" : "->";
        System.out.printf("%s %s %s%n", source, arrow, target);
    }
}