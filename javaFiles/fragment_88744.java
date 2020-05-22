Properties properties = new Properties();
try {
    properties.load(new FileInputStream("/my/path/John.properties"));
} catch (IOException e) {
    ...
}
System.out.println(properties.getProperty("Name")); // Prints John