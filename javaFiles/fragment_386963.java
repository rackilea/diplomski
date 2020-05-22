List<Order> o  = orders.stream().collect(
    Collectors.collectingAndThen(
        Collectors.groupingBy(Order::getPrice,Collectors.summingInt(Order::getQuantity)),
        map -> map.entrySet().stream()
                             .map(e -> new Order(e.getKey(), e.getValue()))
                             .collect(Collectors.toList())));