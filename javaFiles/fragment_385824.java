Path configParent;

String appData = System.getEnv("APPDATA");
if (appData != null) {
    configParent = Paths.get(appData);
} else {
    configParent = Paths.get(
        System.getProperty("user.home"), "AppData", "Local");
}

Path configDir = configParent.resolve(applicationName);
Files.createDirectories(configDir);

Path userConfigFile = configDir.resolve("config.json");