Map<Boolean,Long> counts = results.stream()
    .collect(Collectors.collectingAndThen(
        Collectors.toMap(r -> (int)r.getId(), Resultx::getPassed, Boolean::logicalAnd),
        m -> m.values().stream()
            .collect(Collectors.partitioningBy(b -> b, Collectors.counting()))
    ));