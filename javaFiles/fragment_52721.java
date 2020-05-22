points.stream().forEach(p -> {
    Cluster min = clusters.stream()
        .min(Comparator.comparingDouble(c -> determineDistance(p, c))).get();
    // your original code used the custerNumber to lookup the Cluster in
    // the list, don't know whether this is this really necessary
    min = clusters.get(min.clusterNumber - 1);

    // didn't find a better way considering your current code structure
    synchronized(min) {
        min.points.add(p);
    }
 });
 List<Cluster> newClusters = clusters.stream()
    .map(c -> new Cluster(
       c.points.stream().mapToDouble(p -> p.x).sum()/c.points.size(),
       c.points.stream().mapToDouble(p -> p.y).sum()/c.points.size(),
       c.clusterNumber))
    .collect(Collectors.toList());
}