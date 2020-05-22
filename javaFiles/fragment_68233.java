List<A> result = list.stream()
    .collect(Collectors.groupingBy(A::getId))
    .values().stream()
    .map(grouped -> new A(grouped.get(0).getId(), grouped.get(0).getName(),
            grouped.stream().map(A::getList).flatMap(List::stream)
                .collect(Collectors.toList())))
    .collect(Collectors.toList());