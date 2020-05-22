mapper.setPropertyNamingStrategy(new PropertyNamingStrategy.PropertyNamingStrategyBase() {
    @Override
    public String translate(String propertyName) {
        return propertyName.toLowerCase();
    }
});