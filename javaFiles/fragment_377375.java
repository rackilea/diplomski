List<MyClass> myList = items.entrySet()
    .stream()
    .flatMap(entry -> entry.getValue().entrySet()
        .stream()
        .map(innerEntry -> new MyClass(entry.getKey(), innerEntry.getKey(), innerEntry.getValue()))
    )
    .collect(Collectors.toList());