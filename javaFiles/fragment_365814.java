persons.stream().collect(Collectors.groupingBy(
   Person::getName,
   HashMap::new,
   Collectors.mapping(
      p -> p.getHeight() * p.getWeight()
      Collectors.toList())));