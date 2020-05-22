List<PartialSpeed> maxSpeedPerSegment =
    speedsPerRoadPerSegment.values().stream()
        .flatMap(m -> m.values().stream())
        .filter(list -> ! list.isEmpty())
        .map(list -> Collections.max(list, Comparator.comparing(PartialSpeed::getnVelFfs)))
        .collect(Collectors.toList());