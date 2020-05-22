File configFile = new File(myConfigDirPath + "myConfig.txt");
try (InputStream is = new BufferedInputStream(
    configFile.exists()
        ? new FileInputStream(configFile)
        : MyApplication.class.getResourceAsStream(
            configFile.toString().replace('\\', '/')))) {

    // do something
}