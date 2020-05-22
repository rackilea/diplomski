Stream.of(petStore.getCatsForSale())
    .filter(cats -> !cats.isEmpty())
    .flatMap(cats -> {
        logger.info("Processing for cats: " + cats.size());
        return cats.stream();
    })
    .forEach(Cat::giveFood);