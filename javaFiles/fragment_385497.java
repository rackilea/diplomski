public static String getMessageProperty(String code) {
    Properties prop = new Properties();
    String value = "";
    try {

        InputStream inputStream = this.class.getClassLoader().getResourceAsStream("message.properties");
        prop.load(inputStream);
        value = prop.getProperty(code);
        inputStream.close();

    } catch (IOException e) {

        e.printStackTrace();
    }

    return value;
}