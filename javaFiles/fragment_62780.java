map.entrySet()
            .stream()
            .collect(Collectors.groupingBy(
                    Entry::getValue,
                    HashMap::new,
                    Collectors.mapping(Entry::getKey, Collectors.toList())));