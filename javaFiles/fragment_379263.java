public class CoinFactory {

    // Concrete coin is an internal implementation class whose details don't
    // need to be known outside of the CoinFactory class.
    // Users just see it as interface Coin.
    private static class ConcreteCoin implements Coin {
        private final String name;
        private final String abbreviation;
        private final BigDecimal value;
        private final String unit;

        ConcreteCoin(String name, String abbreviation, BigDecimal value, String unit) {
            this.abbreviation = abbreviation;
            this.name = name;
            this.value = value;
            this.unit = unit;
        }

        public String name() { return name; }
        public String abbreviation() { return abbreviation; }
        public BigDecimal value() { return value; }
        public String unit() { return unit; }
    }

    // Sets for enforcing uniqueness of names and abbreviations
    private Set<String> names = new HashSet<>();
    private Set<String> abbreviations = new HashSet<>();

    // All coins must have one of the following ISO currency codes as the 'unit' field.
    private final Set<String> allIsoCurrencyCodes =
            Set.of("CLP", "GBP", "EUR", "CAD", "USD", "XXX" /* , ... */);

    private List<Coin> allCoins = new ArrayList<>(
            List.of(createCoin("Pesos chilenos", "CLP", BigDecimal.ONE, "CLP")));

    private List<Coin> unmodifiableListOfAllCoins =
            Collections.unmodifiableList(allCoins);


    public Coin createCoin(String name, String abbreviation, BigDecimal value, String unit) {
        if (!names.add(name))
            throw new IllegalArgumentException("Name already exists: " + name);
        if (!abbreviations.add(abbreviation))
            throw new IllegalArgumentException("Abbreviation already exists: " + abbreviation);
        if (!allIsoCurrencyCodes.contains(unit))
            throw new IllegalArgumentException("Coin unit is not a recognised ISO currency code: " + unit);

        Coin coin = new ConcreteCoin(name, abbreviation, value, unit);
        allCoins.add(coin);
        return coin;
    }

    public Collection<Coin> allCoins() {
        return unmodifiableListOfAllCoins;
    }
}