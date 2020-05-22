String expectedItem = "test";
List<Family> families = house1.familyList.stream()
                .filter(f -> f.personList.stream()
                        .anyMatch(p ->p.itemList.stream()
                                .anyMatch(i -> i.name.equals(expectedItem))))
                .collect(Collectors.toList());