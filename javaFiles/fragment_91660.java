List result = list.stream()
    .limit(1)
    .flatMap(info -> info.getMap().stream())
    .filter( entry -> entry.getKey().equals("test"))
    .map(entry::getValue)
    .collect(Collectors.toList());