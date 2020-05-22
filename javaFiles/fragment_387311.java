public static Comparator<Person> parsePersonSortBy(String sortBy) {
    return parseSortBy(sortBy, field -> {
        switch (field) {
            case "firstname": return Comparator.comparing(Person::getFirstName);
            case "lastname":  return Comparator.comparing(Person::getLastName);
            case "age":       return Comparator.comparingInt(Person::getAge);
            case "country":   return Comparator.comparing(Person::getCountry);
            default: throw new IllegalArgumentException("Unknown sort spec: " + field);
        }
    });
}