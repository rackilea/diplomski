@Builder
    @Getter
    @ToString
    public static class Order {
        private Customer customer;
        private Product product;
        private Integer quantity;
        private LocalDate estimatedRealizationDate;
        private BigDecimal discount = BigDecimal.ZERO;

        public boolean threePercent(){
            return Period.between(this.getCustomer().birthDate, LocalDate.now()).getYears() < MAXIMAL_AGE_WITH_DISCOUNT;
        }

        public boolean twoPercent(){
            return Period.between(this.estimatedRealizationDate, LocalDate.now()).getYears() < MAXIMAL_DATES_NUMBER_FOR_DISCOUNT;
        }


    }

    public static Order update(Order o){
        if(o.threePercent()){
            o.discount = DISCOUNT_RATIO_FOR_CUSTOMER_YOUNGER_THAN_25;
        }else{
            if(o.twoPercent()){
                o.discount = DISCOUNT_RATIO_FOR_ESTIMATED_DELIVERY_DATE_SMALLER_THAN_2;
            }
        }
        return o;
    }

    public static BigDecimal totalPriceOfAllOrdersAfterPriceReduction(List<Order> orders){
        return orders
                .stream()
                .map(Scratch::update)
                .peek(System.out::println)
                .map(o -> o.product.price.multiply(o.discount).multiply(BigDecimal.valueOf(o.quantity)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }