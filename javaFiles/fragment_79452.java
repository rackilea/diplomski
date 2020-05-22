List<People> peoples = nameSet.stream()
  .map(name -> {
    People people = new People();
    people.setName(name);
    return people;
  }).collect(Collectors.toList());