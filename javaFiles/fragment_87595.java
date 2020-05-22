interface MoneyType {
    public int getMoney();
    public String getMoneyName();
    public String getMessage();
}

public enum MoneyTypes implements MoneyType {
    DOLLAR(15, "Dollar"), EURO(15, "Dollar"), FRANK(15, "Dollar"), MARK(15, "Dollar"), POUND(15, "Dollar");

    private final int amount;
    private final String moneyName;

    MoneyTypes(int amount, String name) {
        this.amount = amount;
        this.moneyName = name;
    }

    @Override
    public int getMoney() {
        return this.amount;
    }

    @Override
    public String getMoneyName() {
        // moneyName is assigned the value of name
        // You were returning name();
        // Two different values, decide which you want to return.
        return this.moneyName;
    }

    @Override
    public String getMessage() {
        return "got the message";
    }
}