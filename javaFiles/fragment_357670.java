public class UserAccount implements HasMoney {
    @JsonIgnore
    private BigDecimal money;

    // Other variable declarations, constructors

    @Override
    @JsonProperty
    public BigDecimal getMoney() {
        return money;
    }

    @JsonIgnore
    @Override
    public void setMoney(final BigDecimal money) {
        this.money = money;
    }

    // Other getters/setters
}