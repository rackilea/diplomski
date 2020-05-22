Properties p = new Properties();
try (InputStream is = getClass().getClassLoader().getResourceAsStream("xyz.properties")) {
   p.load(is);
}
catch (IOException e) {
   // Handle as appropriately.
}
System.out.println("mykey=" + p.getProperty("mykey"));