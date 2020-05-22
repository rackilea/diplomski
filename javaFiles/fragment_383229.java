List<Item> result = list
    .stream()
    // build a Map<Integer, List<String>>
    .collect(Collectors.groupingBy(Item::getId, Collectors.mapping(Item::getType, Collectors.toList())))
    .entrySet()
    .stream()
    // transform an entry to an item
    .map(i -> new Item(i.getKey(), String.join(", ", i.getValue().toArray(new String[0]))))
    .collect(Collectors.toList());