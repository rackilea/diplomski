return Stream.of(
        paths.values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Flight::getStartingLocation))
).flatMap(flights ->
        Stream.of(
                new HashMap<>(Map.of(origin, new Flight(origin, origin)))
        ).peek(back ->
                Stream.iterate(
                        List.of(origin),
                        list -> list.stream().flatMap(
                                now -> flights.getOrDefault(now, Collections.emptyList()).stream()
                                        .filter(flight -> back.putIfAbsent(flight.getDestination(), flight) == null)
                                        .map(Flight::getDestination)
                        ).collect(Collectors.toList())
                ).filter(list -> list.contains(destination)).findFirst()
        ).map(back ->
                Stream.iterate(
                        new Flight(destination, null),
                        now -> back.get(now.getStartingLocation())
                )
                        .skip(1)
                        .takeWhile(flight -> !flight.getDestination().equals(origin))
                        .collect(Collectors.toList())
        )
)
        .map(ArrayList::new)
        .peek(Collections::reverse)
        .findFirst().get();