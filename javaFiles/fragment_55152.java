String USERNAME = System.getEnv("OPENSHIFT_MYSQL_DB_USERNAME");
String PASSWORD = System.getEnv("OPENSHIFT_MYSQL_DB_PASSWORD");
String DB_NAME = System.getEnv("OPENSHIFT_APP_NAME");
String FORNAME_URL = "com.mysql.jdbc.Driver";
String URL = "jdbc:"+System.getEnv("OPENSHIFT_MYSQL_DB_URL")+ DB_NAME;
Connection m_connection = DriverManager.getConnection(URL , USERNAME , PASSWORD);