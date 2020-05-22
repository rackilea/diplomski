try {
    driver = (Driver) Class.forName("org.sqlite.JDBC").newInstance();
    DriverManager.registerDriver(driver);
} catch (SQLException e) {
    e.printStackTrace();
} catch (ClassNotFoundException e) {
    e.printStackTrace();
} catch (IllegalAccessException e) {
    e.printStackTrace();
} catch (InstantiationException e) {
    e.printStackTrace();
}