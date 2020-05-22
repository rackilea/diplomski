Map<String, Optional<Item>> maxValueMap = firstList.stream()
            .collect(Collectors.groupingBy(Item::getName, Collectors.maxBy(Comparator.comparing(Item::getValue))));

    List<Optional<Item>> secondListContainsItems = secondList
            .stream()
            .map(item -> maxValueMap.get(item.getName()))
            .collect(Collectors.toList());

    secondListContainsItems.forEach(System.out::println);