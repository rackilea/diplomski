Collection<Town> towns = getAllTowns(routes);
Map<Town, Integer> distances = towns.stream()
    .filter(town -> !originTown.equals(town))
    .map(town -> routes.stream()
        .filter(route -> route.hasOrigin(originTown) && route.hasDestine(town))
        .findFirst())
    .filter(Optional::isPresent)
    .collect(toMap(route -> route.get().getDestine(), route -> route.get().getDistance()));
towns.stream()
    .filter(town -> !distances.containsKey(town))
    .forEach(town -> distances.put(town, maxDistance));