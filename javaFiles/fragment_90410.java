List<List<String>> listOflists =
    mapOfMaps.values()
             .stream()
             .map(m -> m.entrySet()
                        .stream()
                        .flatMap(e->Stream.of(e.getKey(),e.getValue()))
                        .collect(Collectors.toList()))
             .collect(Collectors.toList());