public Bus createBus(List<String> passengers) {
    return passengers.stream()
            .map(name -> new Person(name))
            .collect(Collectors
                    .collectingAndThen(Collectors.toList(),people -> new Bus(people)));
}