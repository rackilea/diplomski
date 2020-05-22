Map<LocalDate, List<Item>> groupedItems = itemsToBeGrouped.stream()
    .collect(Collectors.groupingBy(i -> groupingDates.stream()
        .filter(d -> isActiveOnDate(i, d))
        .findFirst() // Optional<Date>
        .get() // will throw if nothing matches
    ));