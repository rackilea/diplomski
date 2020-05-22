Map<String, Long> r = myList.stream()
        .collect(Collectors.groupingBy(MyObject::getField1))
        .entrySet().stream()
        .map(e -> new AbstractMap.SimpleEntry<>(e.getKey(),
                e.getValue().stream().filter(distinctByKey(MyObject::getField2)).count()))
        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));