private Specification<Country> joinContryInfo() {
    return (root, query, cb) -> {
        root.fetch(Country_.countryInfo);
        // here you can fetch more entities if you need...
        return null;
    };
}