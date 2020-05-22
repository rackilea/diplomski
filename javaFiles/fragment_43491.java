List<Foo> notInIntersectList = list1.stream()
        .filter(fooElementFromList1 -> list2
                .stream()
                .noneMatch(fooElementFromList2 -> fooElementFromList2.getBoo() == fooElementFromList1.getBoo()))
        .collect(Collectors.toCollection(ArrayList::new));

list2.stream()
        .filter(fooElementFromList2 -> list1
            .stream()
            .noneMatch(fooElementFromList1 -> fooElementFromList1.getBoo() == fooElementFromList2.getBoo()))
        .forEach(notInIntersectList::add);