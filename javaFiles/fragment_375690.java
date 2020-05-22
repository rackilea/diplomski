Map<String, Double> map =
        persons.stream().collect(
            groupingBy(
                p -> p.getCountry(),
                averagingInt(p -> p.getAge())
            )
        );

persons.stream().filter(p -> p.getAge() > map.get(p.getCountry())).collect(toList());