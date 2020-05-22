List<GroupedPersons> list = persons.stream()
                                    .collect(Collectors.groupingBy(p -> p.getDept()))
                                    .entrySet()
                                    .stream()
                                    .map(ent -> new GroupedPersons(
                                                ent.getKey(),
                                  ent.getValue().stream().mapToInt(p -> p.getAmount()).sum(),
                                                ent.getValue()))
                                    .collect(Collectors.toList());