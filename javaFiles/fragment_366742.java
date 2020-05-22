String insertTableSQL = "INSERT INTO temp"
        + "(USER_ID, Certificate_Code) VALUES"
        + "(?,?)";

try {
    dbConnection = getDBConnection();
    preparedStatement = dbConnection.prepareStatement(insertTableSQL);

    for(String certif : selectedCertificate) {
        preparedStatement.setInt(1, 50);
        preparedStatement.setString(2, certif);
        preparedStatement.addBatch();
    }

    // execute insert SQL stetement
    preparedStatement.executeUpdate();

    dbConnection.commit();
    System.out.println("Record is inserted");

} catch (SQLException e) {

    System.out.println(e.getMessage());

}