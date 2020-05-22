public class Test {
        public static void main(String[] args) throws ClassNotFoundException, SQLException {
            String tableName = "demo";
            String column1 = "Id";
            String column1Type = "int";
            String column2 = "name";
            String column2Type = "varchar(30)";
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sample";
            Connection connection = DriverManager.getConnection(url, "username", "password");
            Statement stmt = connection.createStatement();
            String query = "create table " + tableName + " ( " + column1+" " + column1Type +  " , " +
                    column2 +" " + column2Type + " )";
            System.out.printf(query);
            stmt.executeUpdate(query);
            stmt.close();
        }
    }