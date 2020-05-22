Map<String, List<Country>> countryStatistics = new Map<>();    
countryStatistics.put(
    "population", 
    new ArrayList<Country>(
        Collections.sort(
            countries, 
            new Comparator<Country>() {
                int compare(Country c1, Country c2) {
                    return c1.getPopulation() - c2.getPopulation();
                }
            }
        )
    )
);