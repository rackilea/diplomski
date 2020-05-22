List<Money> result = moneyList.stream()
    .collect(
        groupingBy(
            Money::getCurrencyUnit,
            reducing(BigDecimal.ZERO, Money::getAmount, BigDecimal::add)))
    .entrySet().stream()
    .map(e -> new Money(e.getKey(), e.getValue())
    .collect(toList());