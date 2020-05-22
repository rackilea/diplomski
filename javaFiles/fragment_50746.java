products.stream()
        .filter(
            order ->
                order.getEstimatedRealizationDate().compareTo(begin) > 0
                    && order.getEstimatedRealizationDate().compareTo(end) < 0)
        .map(order -> order.getProduct().getPrice())
        .reduce(ZERO, BigDecimal::add)
        .divide(valueOf(productList.size()), 3, RoundingMode.CEILING);