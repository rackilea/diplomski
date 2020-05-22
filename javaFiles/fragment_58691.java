Collection<DataSet> convert(List<MultiDataPoint> multiDataPoints) {
    Map<String, DataSet> result = new HashMap<>();
    multiDataPoints.forEach(pt ->
        pt.keyToData.forEach((key, value) ->
            result.computeIfAbsent(
                key, k -> new DataSet(k, new ArrayList<>()))
            .dataPoints.add(new DataPoint(pt.timestamp, value))));
    return result.values();
}