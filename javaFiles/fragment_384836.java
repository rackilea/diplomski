Map<String,List<Person>> map = truthTable.get().collect(
    Collectors.toMap(np -> np.toString(), // Key is string like "T T F"
        // Value is the list of persons for which given combination is true
        np -> persons.stream().filter(np).collect(Collectors.toList()),
        // Merge function: actually should never happen; 
        // you may throw assertion error here instead
        (a, b) -> a,
        // Use LinkedHashMap to preserve an order
        LinkedHashMap::new));