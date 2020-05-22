Map<Object, Object> map = Stream.of(
    new SimpleEntry<>(
      "date",
      customList.stream().map(MoreCustomDTO::getDate).collect(Collectors.toList())
    ),
    new SimpleEntry<>(
      "money",
      customList.stream().map(MoreCustomDTO::getMoney).collect(Collectors.toList())
    )
  ).collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));