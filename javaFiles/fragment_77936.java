inputStream.collect(
  Collectors.groupingBy(
    MyClass::getC,
    Collectors.mapping(
      MyClass::getB,
      Collectors.toList())));