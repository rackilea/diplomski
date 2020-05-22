public static void getNamesOfAdultsSortedByAge(Stream<Person> stream) {
    List<String> sorted = stream.filter(p -> p.getAge() >= 18)
                                .sorted((x, y) -> Integer.compare(x.getAge(),y.getAge()))
                                .map(e -> e.getFirstName() + " " + e.getLastName())
                                .collect(Collectors.toList());
    System.out.println(sorted);
}