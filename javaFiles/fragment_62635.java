InputStream in = new FileInputStream("database.properties");
Properties props = new Properties();
props.load(in);
in.close();

String driver = props.getProperty("jdbc.driver");
Class.forName(driver);

String url = props.getProperty("jdbc.url");
String username = props.getProperty("jdbc.username");
String password = props.getProperty("jdbc.password");

Connection conn = DriverManager.getConnection(url, username, password);