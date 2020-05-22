public enum ProductType {


    FOUNDATION_OR_PAYMENT("946", "949", "966"),
    NOVA_L_S_OR_SESAM("907", "222");

    static Map<String, ProductType> MAP;

    static {
        MAP = Arrays.stream(ProductType.values())
                    .flatMap(x -> Arrays.stream(x.type)
                                        .map(y -> new SimpleEntry<>(x, y)))
                    .collect(Collectors.toMap(Entry::getValue, Entry::getKey));
    }

    private String[] type;

    ProductType(String... type) {
        this.type = type;
    }

    public boolean isAnyProductTypes(String actualProductType, ProductType productTypes) {
        return Optional.ofNullable(MAP.get(actualProductType))
                       .map(productTypes::equals)
                       .orElse(false);
    }
}