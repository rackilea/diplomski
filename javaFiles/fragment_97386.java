class Main {
  public static void main(final String [] args) throws IOException {
    //load default properties
    final Properties defaultProp = new Properties();
    defaultProp.load(Main.class.getResourceAsStream("default.properties"));

    //load user properties
    final Properties userProp = new Properties();
    userProp.load(new FileInputStream(new File("./user.properties")));

    final Properties appProp = new Properties();

    //mix properties
    appProp.putAll(defaultProp);
    appProp.putAll(userProp);

    System.out.println(appProp);
  }  
}