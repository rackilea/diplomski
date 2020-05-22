File configFile = new File(ProfessionalWarns.getPluginDataFolder(),
    "config.yml");
if (!configFile.exists()) {
    boolean fileWasCreated = configFile.createNewFile();
    forceConfigUpdate = true;
}