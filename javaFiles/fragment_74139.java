public Version waitForNewConfig() throws Exception {
    NewVersionIsReady newVersionIsReady = new NewVersionIsReady(deploymentClient.getCurrentConfigVersion(appName));
    await().atMost(1, MINUTES).pollInterval(5, SECONDS).until(newVersionIsReady);

    return newVersionIsReady.getNewVersion();
}

private final class NewVersionIsReady implements Callable<Boolean> {
    private final Version oldVersion;
    private Version newVersion;

    private NewVersionIsReady(Version oldVersion) {
        this.oldVersion = oldVersion;
    }

    public Boolean call() throws Exception {
        Version newVersion = deploymentClient.getCurrentConfigVersion(appName);

        return !oldVersion.equals(newVersion);
    }

    public Version getNewVersion() {
        return newVersion;
    }
}