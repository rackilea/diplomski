Map<Integer, Double> unitOfWork = new HashMap<>(); // innermost map you've attained ('yearToAverageTemperature' map)
unitOfWork = unitOfWork.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByKey())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
// the values sorted based on the year from a sorted map
List<Double> srtedValPerYear = new ArrayList<>(unitOfWork.values());
// average of deltas from the complete list 
double avg = IntStream.range(0, srtedVal.size() - 1)
        .mapToDouble(i -> (srtedVal.get(i + 1) - srtedVal.get(i)))
        .average().orElse(Double.NaN);