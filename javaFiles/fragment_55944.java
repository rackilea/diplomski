cbCountryList.setConverter(new StringConverter<CountryDetails>() {
    @Override
    public String toString(CountryDetails object) {
        return object.getName();
    }

    @Override
    public CountryDetails fromString(String string) {
        return null;
    }
});