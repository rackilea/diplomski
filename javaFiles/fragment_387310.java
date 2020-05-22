public static Comparator<Person> parseSortBy(String sortBy) {
    Comparator<Person> sortComparator = null;
    for (String field : sortBy.split(";")) {
        Comparator<Person> c;
        switch (field) {
            case "firstname":
                c = Comparator.comparing(Person::getFirstName);
                break;
            case "lastname":
                c = Comparator.comparing(Person::getLastName);
                break;
            case "age":
                c = Comparator.comparingInt(Person::getAge);
                break;
            case "country":
                c = Comparator.comparing(Person::getCountry);
                break;
            default:
                throw new IllegalArgumentException("Unknown sort spec: " + field);
        }
        sortComparator = (sortComparator == null ? c : sortComparator.thenComparing(c));
    }
    return sortComparator;
}