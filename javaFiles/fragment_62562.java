public static void insertAutoIncrement_SQL(String UserName, String Language, String Message) {
    String DB_URL = "jdbc:mysql://localhost:3306/test", DB_User = "root", DB_Password = "";

    String insertSQL = "INSERT INTO `unicodeinfo`( `UserName`, `Language`, `Message`) VALUES (?,?,?)";
            //"INSERT INTO `unicodeinfo`(`id`, `UserName`, `Language`, `Message`) VALUES (?,?,?,?)";
    int primkey = 0 ;
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection(DB_URL, DB_User, DB_Password);

        String columnNames[] = new String[] { "id" };

        PreparedStatement pstmt = conn.prepareStatement( insertSQL, columnNames );
        pstmt.setString(1, UserName );
        pstmt.setString(2, Language );
        pstmt.setString(3, Message );

        if (pstmt.executeUpdate() > 0) {
            // Retrieves any auto-generated keys created as a result of executing this Statement object
            java.sql.ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if ( generatedKeys.next() ) {
                primkey = generatedKeys.getInt(1);
            }
        }
        System.out.println("Record updated with id = "+primkey);
    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
}