public List<PolygonStat> groupItemsByTypeAndWeight(List<Item> items){
    return items.stream()
        .collect(Collectors.groupingBy(item -> item.type))
        .entrySet()
        .stream()
        .map(entry -> createdWeightedList(entry.getKey(), entry.getValue()))
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
}