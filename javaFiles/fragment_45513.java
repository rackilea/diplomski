@SuppressWarnings("unchecked")
public <T> Function<T, T> getCreateFunction(Class<T> type) {

    AreaService areaService = new AreaService();
    CountryService countryService = new CountryService();
    if (type == Area.class) {
        return t -> (T) areaService.createArea((Area)t);
    } else if (type == Country.class) {
        return t -> (T) countryService.createCountry((Country)t);
    }
    return null ; // may be better to throw an IllegalArgumentException("Unsupported type") 
}