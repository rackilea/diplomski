Map<Integer, List<String>> result = persons.stream()
        .collect(Collectors.groupingBy(
            p -> (p.getAge() / 10) * 10, // some integer division trick
            Collectors.mapping(
                p -> p.getFirstName() + " " + p.getLastName() +":" + p.getSalary(),
                Collectors.toList()
            )
        ));