public <T> T getValue(String component, String key, T defaultValue, Function<String, T> parser) throws ConfigException {
    try {
        String value = this.getString( component, key, String.valueOf(defaultValue) );
        return parser.apply(value);
      } catch (Exception e) {
        logger.log(Level.SEVERE, e.getMessage(), e);
        throw new ConfigException( e.getMessage(), e.getCause() );
      }
}

public Integer getInteger(String component, String key, int defaultValue) throws ConfigException {
    return getValue(component, key, defaultValue, Integer::parseInt );
}

public Double  getDouble(String component, String key, double defaultValue) throws ConfigException {
    return getValue(component, key, defaultValue, Double::parseDouble );
}

public Boolean getBoolean (String component, String key, boolean defaultValue) throws ConfigException {
    return getValue(component, key, defaultValue, Boolean::parseBoolean);
}