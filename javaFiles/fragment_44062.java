final List<Person> persons = new ArrayList<>();

// Populate list

Collections.sort(persons, (p1, p2) -> {
    // Not null-safe
    return p1.getName().compareTo(p2.getName());
});