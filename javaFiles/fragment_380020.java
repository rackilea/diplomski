Select country = form.addItem().addSelect("country ");
country.setLabel("Country");
country.addOption("", "Please select your country");

Enumeration<?> countries = ConfigurationManager.propertyNames("countries");
while (countries.hasMoreElements()) {
    String key = (String) countries.nextElement();
    String value = ConfigurationManager.getProperty("countries", key);
    country.addOption(key, value);
}