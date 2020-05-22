void loadTokensAmount() {
    File tokenFile = getTokenFile(); //Make sure it exists
    FileConfiguration fileConfig = YamlConfiguration.loadConfiguration(tokenFile); //Load configuration
    try {
        fileConfig.load(tokenFile); //Load contents of file
        for (String id : fileConfig.getKeys(false)) { //Get the keys
            tokens.put(id, fileConfig.getInt(id)); //Add values to map
        }
    } catch (Exception ex) {
        ex.printStackTrace();;
    }
}