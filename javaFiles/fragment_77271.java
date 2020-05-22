class Money {
    private final BigDecimal price;
    public Money(BigDecimal bigDecimal) {
        this.price = bigDecimal;
    }
    @JsonValue // <<< this
    public BigDecimal getPrice() {
        return price;
    }
}