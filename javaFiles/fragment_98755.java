KStream<String, OrderValue>[] forks = ordersWithTotals.branch(
    (id, orderValue) -> orderValue.getValue() >= FRAUD_LIMIT,
    (id, orderValue) -> orderValue.getValue() < FRAUD_LIMIT);

forks[0].mapValues(
    orderValue -> new OrderValidation(orderValue.getOrder().getId(), FRAUD_CHECK, FAIL))
    .to(ORDER_VALIDATIONS.name(), Produced
        .with(ORDER_VALIDATIONS.keySerde(), ORDER_VALIDATIONS.valueSerde()));

forks[1].mapValues(
    orderValue -> new OrderValidation(orderValue.getOrder().getId(), FRAUD_CHECK, PASS))
    .to(ORDER_VALIDATIONS.name(), Produced
  .with(ORDER_VALIDATIONS.keySerde(), ORDER_VALIDATIONS.valueSerde()));