/**
 * @return the Maven settings
 * @throws SettingsBuildingException if the file cannot be loaded
 */
private Settings getMavenSettings() throws SettingsBuildingException 
{
    String userHome = System.getProperty("user.home");
    File userMavenConfigurationHome = new File(userHome, ".m2");
    String envM2Home = System.getenv("M2_HOME");
    File DEFAULT_USER_SETTINGS_FILE = new File(userMavenConfigurationHome, "settings.xml");
    File DEFAULT_GLOBAL_SETTINGS_FILE = new File(System.getProperty("maven.home", envM2Home != null ? envM2Home : ""),
        "conf/settings.xml");
    SettingsBuildingRequest settingsBuildingRequest = new DefaultSettingsBuildingRequest();
    settingsBuildingRequest.setSystemProperties(System.getProperties());
    settingsBuildingRequest.setUserSettingsFile(DEFAULT_USER_SETTINGS_FILE);
    settingsBuildingRequest.setGlobalSettingsFile(DEFAULT_GLOBAL_SETTINGS_FILE);

    DefaultSettingsBuilderFactory mvnSettingBuilderFactory = new DefaultSettingsBuilderFactory();
    DefaultSettingsBuilder settingsBuilder = mvnSettingBuilderFactory.newInstance();
    SettingsBuildingResult settingsBuildingResult = settingsBuilder.build(settingsBuildingRequest);
    return settingsBuildingResult.getEffectiveSettings();
}