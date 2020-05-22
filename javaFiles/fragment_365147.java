Map<String, DoubleSummaryStatistics> stats = browserData.values().stream()
        .flatMap(m -> m.entrySet().stream()) //Stream the inner maps' entrySets
        .collect(groupingBy(Entry::getKey, summarizingDouble(Entry::getValue)));
DoubleSummaryStatistics ds = stats.getOrDefault("EU", new DoubleSummaryStatistics());
System.out.println("sumEu = " + ds.getSum());
System.out.println("avgEu = " + ds.getAverage());