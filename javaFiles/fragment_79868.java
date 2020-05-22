WebAppProviderCustom webAppProvider = new WebAppProviderCustom();
webAppProvider.setMonitoredDirName("webapps");
webAppProvider.setScanInterval(1);
webAppProvider.setExtractWars(true);
webAppProvider.setDefaultsDescriptor("webdefault.xml");
webAppProvider.setTempDir(new File("work"));

String webDefault = Thread.currentThread().getContextClassLoader().getResource("webdefault.xml").getPath();
if (webDefault != null) {
    File f = new File(webDefault);
    if (f.exists() && !f.isDirectory()) {
        webAppProvider.setDefaultsDescriptor(webDefault);
    }
}