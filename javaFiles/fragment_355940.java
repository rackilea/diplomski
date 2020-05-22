// We're using the TypeToken class, to handle generic types
Type type = new TypeToken<List<Person>>() { }.getType();
List<Person> newPeople = new Gson().fromJson(json, type);

// Print all names
newPeople.stream()
    .map(t -> t.name)
    .forEach(System.out::println);