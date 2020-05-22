Map<String, Map<String, List<String>>> map = new HashMap<>();

    neighborhoods.forEach(neighborhood -> {

        Map<String, List<String>> m = map.computeIfAbsent(neighborhood.getId(), (key) -> new HashMap<>());
        neighborhood.getStreets()
                    .forEach(street -> {
                        m.merge(street.getId(),
                                street.getHouses()
                                      .stream()
                                      .map(House::getId)
                                      .collect(Collectors.toCollection(ArrayList::new)),
                                (oldV, newV) -> {
                                    oldV.addAll(newV);
                                    return oldV;
                                }
                        );
                    });
    });