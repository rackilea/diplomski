orders.stream()
    .collect(Collectors.groupingBy(
                o -> new SimpleEntry<>(o.getDate().getMonth(), o.getCategory()),
                Collectors.summingInt(Order::getQuantity)))
    .entrySet()
    .stream()
    .max(Entry.comparingByValue())
    .ifPresent(cat -> System.out.println(
                "Month: " + cat.getKey().getKey() + 
                " - Category: " + cat.getKey().getValue() + 
                " - Quantity: " + cat.getValue()));