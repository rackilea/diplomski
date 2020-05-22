Stream.of(petStore.getCatsForSale())
    .filter(cats -> !cats.isEmpty())
    .mapToInt(cats -> {
        cats.forEach(Cat::giveFood);
        return cats.size();
    })
    .findAny()
    .ifPresent(count -> logger.info("Processing for cats: " + count));