public static void checkJSon() {
    try {
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL, DB_username, DB_password);
        String q = "SELECT * FROM table_test";
        PreparedStatement preparedStatement = connection.prepareStatement(q);
        preparedStatement.execute();
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("json"));
        }

    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
}