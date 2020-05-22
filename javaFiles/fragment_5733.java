//All the predicates mentioned in here are of type org.apache.kafka.streams.kstream.Predicate
private Predicate<Long, AccountMigrationEvent>>[] getStrategies() {

  List<Predicate<Long, AccountMigrationEvent>> predicates = strategies.stream()
            .map(strategy -> (Predicate<Long, AccountMigrationEvent>>) (key, value) -> strategy.matches(value))
            .collect(toList());

    // branch() method on KStream requires an array so we need to transform our list
    return predicates.toArray(new Predicate[predicates.size()]);
}