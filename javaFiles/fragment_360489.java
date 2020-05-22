import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

Map<CurrencyUnit, BigDecimal> result = moneyList.stream()
    .collect(
        groupingBy(
            Money::getCurrencyUnit,
            reducing(BigDecimal.ZERO, Money::getAmount, BigDecimal::add)));