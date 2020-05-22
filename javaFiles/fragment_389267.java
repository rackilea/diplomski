// define a collection of paths and words somewhere
List<String> paths = new ArrayList<>();
List<String> words = new ArrayList<>();

try {
    // presumably you only want to insert so many records
    int LIMIT = 10000;
    Class.forName("com.mysql.jdbc.Driver");
    connect = DriverManager
            .getConnection("jdbc:mysql://126.32.3.20/fulltext_ltat?"
                + "user=root&password=root");

    String sql = "INSERT IGNORE INTO fulltext_ltat.indextable VALUES (default, ?, ?);";
    preparedStatement = connect.prepareStatement(sql);

    for (int i=0; i < LIMIT; ++i) {
        preparedStatement.setString(1, paths.get(i));
        preparedStatement.setString(2, word.get(i));
        preparedStatement.addBatch();
        if (i % 500 == 0) {
            preparedStatement.executeBatch();
        }
    }

    // execute remaining batches
    preparedStatement.executeBatch();
}
catch (SQLException e) {
    e.printStackTrace();
}
finally {
    try {
        preparedStatement.close();
        connect.close();
    }
    catch (SQLException e) {
        e.printStackTrace();
    }
}