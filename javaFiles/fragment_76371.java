foos = fooTypes
        .stream()
        .map(this::findByType)
        .filter(Optional::isPresent)
        .map(Optional::get)
        .collect(Collectors.toList());