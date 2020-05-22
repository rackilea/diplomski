List result = list.stream()
    .limit(1)
    .flatMap(info -> // <-- removed brace {
        info.getMap().stream()
            .filter( entry -> entry.getKey().equals("test"))
            .map(entry::getValue)
    ) // <-- removed brace here too
    .collect(Collectors.toList());