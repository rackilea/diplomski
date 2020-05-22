// The average of all cities in a country is the average of a country.
AtomicReference<Double> countryValAvg = new AtomicReference<>(0.0);
countriesMap.forEach((country, cityMap) -> {
    // The average of all these deltas is the average annual temperature delta for a city.
    AtomicReference<Double> cityAvgTemp = new AtomicReference<>((double) 0);
    cityMap.forEach((city, yearMap) -> cityAvgTemp.set(cityAvgTemp.get() + averagePerCity(yearMap)));
    double avgAnnualTempDeltaPerCity = cityAvgTemp.get() / cityMap.size();

    countryValAvg.set(countryValAvg.get() + avgAnnualTempDeltaPerCity);
});
System.out.println(countryValAvg.get() / countriesMap.size());