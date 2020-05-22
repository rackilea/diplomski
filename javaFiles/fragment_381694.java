class PricesWrapper {

    // ...

    @JsonDeserialize(using = CustomDeserializer.class)
    private Prices prices;

    // ...
}