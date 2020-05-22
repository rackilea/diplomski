Map<String, List<Data>> dataStatistics = new Map<>();    
dataStatistics.put(
    "population", 
    new ArrayList<Country>(
        Collections.sort(
            countries, 
            new Comparator<Country>() {
                @Override
                public int compare(Country c1, Country c2) {
                    return c1.getValue("population") - c2.getValue("population");
                }
            }
        )
    )
);