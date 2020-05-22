Properties connProperties;
connProperties = new Properties();
connProperties.setProperty("user", getUsername());
connProperties.setProperty("password",getPassword());

con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DataBase, connProperties);