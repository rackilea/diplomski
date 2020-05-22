double avgAnnualTempDeltaPerCity = countriesMap.values().stream()
        .mapToDouble(cityMap -> cityMap.values()
                .stream()
                .mapToDouble(Quick::averagePerCity) // Quick is my class name
                .average()
                .orElse(Double.NaN))
        .average().orElse(Double.NaN);