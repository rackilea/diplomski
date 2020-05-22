try (Connection connection = createConnection(PROPERTIES_FILE_PATH);
     Statement stmt = connection.createStatement();
     ResultSet rs = stmt.executeQuery(queryCareers)) {

    //... rest 
} catch (SQLException e) {
    //... rest
}