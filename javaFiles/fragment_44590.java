Properties p = new Properties();
InputStream s = Main.class.getClassLoader().getResourceAsStream("test/test.properties");
try {
    p.load(s);
    System.out.println(p.get("key"));
    System.out.println(p.get("rawKey"));
}
catch (IOException ioe) {
    ioe.printStackTrace();
}