private Specification<Country> continentEqual(String param) {
    return (root, query, cb) -> {
        Join<Country,CountryInfo> join = (Join) root.fetch(Country_.countryInfo);
        return cb.equal(join.get(CountryInfo_.continent), addWildCards(param));;
    };
}