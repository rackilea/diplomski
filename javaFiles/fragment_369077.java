public void executeCmds(){
    Thread thread = new Thread(() -> {
        createTempDirectory();
        copyConfigPropetiesFileValues();
        copyConfigProperties();
        copyYMLFile();
        copyYMLFileProperties();

        stopTomcatServer();

        deleteOldWar();
        copyNewWar();
        startTomcatServer();

        copyOldConfigFile();
        copyOldYMLFile();
    });
    thread.start();
}