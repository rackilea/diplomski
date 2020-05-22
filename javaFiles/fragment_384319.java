private static List<SurpriseFactory> createSurpriseFactories() {
    return Stream.of(
            createChocolateFactoryIfAccessible(),
            createQuoteFactoryIfAccessible())
            .flatMap(Optional::stream)
            .collect(toList());
}

private static Optional<SurpriseFactory> createChocolateFactoryIfAccessible() {
    try {
        return Optional.of(new ChocolateFactory());
    } catch (NoClassDefFoundError er) {
        return Optional.empty();
    }
}

private static Optional<SurpriseFactory> createQuoteFactoryIfAccessible() {
    try {
        return Optional.of(new QuoteFactory());
    } catch (NoClassDefFoundError er) {
        return Optional.empty();
    }
}