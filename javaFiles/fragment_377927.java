Properties prop = new Properties();

try {
    InputStream in = new FileInputStream("resources/data.properties");
    prop.load(in);
    in.close();

    System.out.println(prop.getProperty("Au333"));
    System.out.println(prop.getProperty("Au375"));
    System.out.println(prop.getProperty("Au500"));
}
catch(Exception e) {
    e.printStackTrace();
}