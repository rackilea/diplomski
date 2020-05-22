Map<Month, BuyerDetails> topBuyers = orders.stream()
    .collect(Collectors.groupingBy(Order::getOrderMonth,
             Collectors.groupingBy(Order::getCustomer,
             Collectors.summingLong(Order::getAmount))))
    .entrySet().stream()
    .collect(Collectors.toMap(Map.Entry::getKey,
             order -> order.getValue().entrySet().stream()
            .max(Comparator.comparingLong(Map.Entry::getValue))
            .map(cust -> new BuyerDetails(cust.getKey(), cust.getValue())).get()));