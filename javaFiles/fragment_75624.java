public static void main(String args[]){
    System.out.println("Main Started");

    settings = new Settings("config.properties");
    String test = settings.getProperty("test");
    String hello = settings.getProperty("hello");

    // say you have another properties named config2.properties to read
    Settings another_settings = new Settings("config2.properties");
    String xxx = settings.getProperty("xxx");
    String yyy = settings.getProperty("yyy");
}