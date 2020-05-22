public List<Long> getSubscribedPeople() {
    return people.entrySet() // set of entries 
        .stream() // stream of entries
        .filter(e -> e.getValue().getStatus() == PersonStatus.SUBSCRIBED) // stream of entries 
        .map(e -> e.getKey()) // stream of longs
        .collect(Collectors.toList()); // list of longs
}