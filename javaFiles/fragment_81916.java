// Get config file, here called "fileConfig"
ConfigurationSection companies = fileConfig.getConfigurationSection("companies"); // The "companies" section of the config file

for (String companyKey : companies.getKeys(false)) { // For each company key in the set
    String name = (String) companies.get(companyKey + ".name"); // Either use the path to retrieve name value

    // OR

    ConfigurationSection companySection = companies.getConfigurationSection(companyKey); // Create a new section one level deeper
    name = (String) companySection.getValues(false).get("name"); // Retrieve name by getting value of key named "name"
}