Tuple2<List<String>, List<Integer>> namesAndAges=
    Stream.of(new Person("Joe", 52), new Person("Alan", 34), new Person("Peter", 42))
        .collect(both(
            Collectors.mapping(p->p.name, Collectors.toList()),
            Collectors.mapping(p->p.age,  Collectors.toList())));
List<String> names = namesAndAges.$1(); // ["Joe", "Alan", "Peter"]
List<Integer> ages = namesAndAges.$2(); // [52, 34, 42]