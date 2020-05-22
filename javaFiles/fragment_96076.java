List<String> result = Stream
        .of("A", "A", "A", "B", "B", "A", "A", "A", "C", "C", "C", "A", "A", "B", "B", "A")
//      .parallel()
        .filter(new NoRepeatFilter<>())
        .collect(Collectors.toList());
System.out.println(result);