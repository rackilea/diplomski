Collection<DataSet> convert(List<MultiDataPoint> multiDataPoints) {
    return multiDataPoints.stream()
        .map(mdp -> mdp.keyToData.entrySet().stream()
            .collect(toMap(e -> e.getKey(), e -> asList(new DataPoint(mdp.timestamp, e.getValue())))))
        .reduce(new HashMap<>(), mapMerger())
        .entrySet().stream()
        .map(e -> new DataSet(e.getKey(), e.getValue()))
        .collect(toList());
}