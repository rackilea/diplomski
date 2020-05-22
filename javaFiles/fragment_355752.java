Function<Person, String> groupingYear = p -> {
     if (p.getYear() > 2015) return "New members";
     else if (p.getYear() < 2009) return "Senior members";
     else return "Normal members";
};

Map<Object, Optional<Person>> map2 = 
    personList.stream()
              .collect(groupingBy(p -> Arrays.asList(groupingYear.apply(p), p.getSex()), maxBy(Comparator.comparingInt(Person::getAge))));