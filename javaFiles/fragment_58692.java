Collection<DataSet> convert(List<MultiDataPoint> multiDataPoints) {
    return multiDataPoints.stream()
        .flatMap(mdp -> mdp.keyToData.entrySet().stream().map(e ->
            new Object() {
                String key = e.getKey();
                DataPoint dataPoint = new DataPoint(mdp.timestamp, e.getValue());
            }))
        .collect(
            collectingAndThen(
                groupingBy(t -> t.key, mapping(t -> t.dataPoint, toList())),
                m -> m.entrySet().stream().map(e -> new DataSet(e.getKey(), e.getValue())).collect(toList())));
}