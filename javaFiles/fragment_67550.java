double averagePerCity(Map<Integer, Double> unitOfWork) {
    unitOfWork = unitOfWork.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    List<Double> srtedVal = new ArrayList<>(unitOfWork.values());
    return IntStream.range(0, srtedVal.size() - 1)
            .mapToDouble(i -> (srtedVal.get(i + 1) - srtedVal.get(i)))
            .average().orElse(Double.NaN);
}