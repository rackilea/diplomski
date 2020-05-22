public Version waitForNewConfig() throws Exception {
    Version[] currentVersionHolder = new Version[1];
    Version oldVersion = deploymentClient.getCurrentConfigVersion(appName);
    await().atMost(1, MINUTES).pollInterval(5, SECONDS).until(() -> {
        Version newVersion = deploymentClient.getCurrentConfigVersion(appName);
        currentVersionHolder[0] = newVersion;
        return !oldVersion.equals(newVersion);
    });

    return currentVersionHolder[0];
}