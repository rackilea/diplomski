List<Item> actualValues =  logged.stream().flatMap(l -> l.items.stream())
        .collect(Collectors.toList());
List<Item> shouldValues = should.stream().flatMap(l -> l.items.stream())
        .collect(Collectors.toList());

BiPredicate<Item, Item> predicate = (item1, item2) -> item1.id.equals(item2.id) 
        && item1.value.equals(item2.value);

boolean res = actualValues.size() == shouldValues.size() //should be same length
        && IntStream.range(0, actualValues.size())
        .filter(i -> !predicate.test(actualValues.get(i), shouldValues.get(i)))
        .count() == 0; //all elements's ID and value must match