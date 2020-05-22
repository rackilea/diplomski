public double retSpeed() {
    Properties prop = new Properties();
    InputStream input = null;

    try {

        input = new FileInputStream("config.properties");
        prop.load(input);
        return Double.parseDouble(prop
                .getProperty("window_close_speed"));

    } catch (IOException ex) {
        ex.printStackTrace();

        // You need to return something here,
        // although it would probably be better to just
        // throw new RuntimeException(ex);
        // in case the property file cannot be read.
        return -1.0d;
    } finally {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}