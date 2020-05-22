static private Properties prop;
static {
    prop = new Properties();
    prop.load(new FileInputStream("defaultDB.properties"));
    db1 = JdbcFactory.getInstance(prop.getProperty("DB1"));
    db2 = JdbcFactory.getInstance(prop.getProperty("DB2"));
}