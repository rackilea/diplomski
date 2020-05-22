// The average of all cities in a country is the average of a country.
AtomicReference<Double> countryValAvg = new AtomicReference<>(0.0);
countriesMap.forEach((country, cityMap) -> {
    // The average of all these deltas is the average annual temperature delta for a city.
    double avgAnnualTempDeltaPerCity = cityMap.values()
            .stream()
            .mapToDouble(Quick::averagePerCity) // Quick is my class name
            .average()
            .orElse(Double.NaN);
    countryValAvg.set(countryValAvg.get() + avgAnnualTempDeltaPerCity);
});
System.out.println(countryValAvg.get() / countriesMap.size());