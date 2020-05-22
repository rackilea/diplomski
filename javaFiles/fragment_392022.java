@Embedded
String currency;

public void setCurrency(Currency currency) {
    this.currency = currency.getCurrencyCode();
}

public Currency getCurrency() {
    return Currency.getInstance(currency);
}