List<Order> o  = orders.stream().collect(
Collectors.collectingAndThen(
    grouping,                                                 // you know this one ;)
    map -> map.entrySet()                        
              .stream()                                       // iterate entries
              .map(e -> new Order(e.getKey(), e.getValue()))  // new Order(qty, price)
              .collect(Collectors.toList())));                // as a List<Order>