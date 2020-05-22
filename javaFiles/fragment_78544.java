Predicate<FooBar> predicate = c -> whatever();

if (condition1) { predicate = predicate.and(c -> whatever1()); }
if (condition2) { predicate = predicate.and(c -> whatever2()); }

List<FooBar> dest = list.stream()
    .filter(predicate)
    .collect(Collectors.toList());