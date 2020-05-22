BigDecimal totalPriceOfAllOrdersAfterPriceReduction() {
        return productList.stream().map(i -> {
            if (between(i.getCustomer().getBirthDate(), LocalDate.now()).getYears() < MAXIMAL_AGE_WITH_DISCOUNT) {
                return i.getProduct().getPrice().multiply(DISCOUNT_RATIO_FOR_CUSTOMER_YOUNGER_THAN_25).multiply(BigDecimal.valueOf(i.getQuantity()));
            } else{
               if (between(i.getEstimatedRealizationDate(), LocalDate.now()).getDays() < MAXIMAL_DATES_NUMBER_FOR_DISCOUNT) {
                   return i.getProduct().getPrice().multiply(DISCOUNT_RATIO_FOR_ESTIMATED_DELIVERY_DATE_SMALLER_THAN_2).multiply(BigDecimal.valueOf(i.getQuantity()));
               }
            }
            return i.getProduct().getPrice();
        }).reduce(BigDecimal.ZERO, BigDecimal::add);
    }