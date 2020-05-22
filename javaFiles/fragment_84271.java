Arrays.stream(args)
      .map(number -> number.split(""))
      .map(Arrays::stream)
      .map(strStream -> strStream.mapToInt(Integer::parseInt))
      .map(IntStream::sum)
      .forEach(System.out::println);