public enum CurrencyType {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25);
    int value;
    CurrencyType(int value) {
       this.value = value;
    }
    int getValue() {
       return value;
    }
}