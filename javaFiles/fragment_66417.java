Map<Merchant,Set<Order>> ordersByMerchant = ... ;

Map<Order,Merchant> result =
    ordersByMerchant.entrySet().stream()
        .map(entry -> entry.getValue().stream()
                      .collect(toMap(order -> order, x -> entry.getKey())))
        .collect(HashMap::new, Map::putAll, Map::putAll);