public enum Coin {
    EUR("EUR", "€"),
    USD("USD", "$");

    private String name;
    private String currency;

    private Coin(String name, String currency) {
        this.name = name;
        this.currency = currency;
    }
}