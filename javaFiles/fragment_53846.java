URL urlConfig = Object.class.getResource(CONFIG_FILE);
if (urlConfig == null) {
    // throw <error>
}
URLConnection connConfig = urlConfig.openConnection();
InputStream isConfig = connConfig.getInputStream(); // do things