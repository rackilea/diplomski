Map<Object, Person> map =
    personList.stream()
              .collect(toMap(p -> Arrays.asList(groupingYear.apply(p), p.getSex()),
                             p -> p,
                             (p1, p2) -> {
                                 if(p1.getAge() > p2.getAge()) return p1;
                                 else return p2;
                             },
                             HashMap::new));