String[] regionArray = {"Japan", "Germany", "USA"};
 List<String> regions = Arrays.asList(regionArray);
 return regions
        .parallelStream()
        .flatMap(r -> loader.getVehicleMakesByRegion(r).stream())
        .map(m->m.getName())
        .collect(Collectors.toCollection(ConcurrentSkipListSet::new));