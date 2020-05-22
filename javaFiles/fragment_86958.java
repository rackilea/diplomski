void saveTokensAmount() {
    File tokenFile = getTokenFile(); //Get the file (make sure it exists)
    FileConfiguration fileConfig = YamlConfiguration.loadConfiguration(tokenFile); //Load configuration
    for (String id : tokens.keySet()) {
        fileConfig.createSection(id); //Create a section
        fileConfig.set(id, tokens.get(id)); //Set the value
    }
    try {
        fileConfig.save(tokenFile); //Save the file
    } catch (IOException ex) {
        ex.printStackTrace();
        //Handle error
    }
}
//Not sure if creating new sections is the most efficient way of storing this data in a YAML file