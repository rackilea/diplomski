List<String> top3Names = people.stream()
        .collect(Collectors2.countByEach(Person::getSports))
        .topOccurrences(3)
        .collect(pair -> pair.getOne().getName());

List<String> expected =
        Arrays.asList("Football", "Handball", "Tennis");

Assert.assertEquals(expected, top3Names);