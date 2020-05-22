String callableSQL = "{call upper(?)}";

try {
    dbConnection = getDBConnection();
    callableStatement = dbConnection.prepareCall(callableSQL);

    callableStatement.setString(1, "lowercase to uppercase");

    //register multiple output parameters to match all return values
    callableStatement.registerOutParameter(1, java.sql.Types.VARCHAR);
    callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
    callableStatement.registerOutParameter(3, java.sql.Types.XYZ);  //any data type here

    callableStatement.execute();

    //do something with your return values
    String xyz = callableStatement.getString(1);
    //... for other items you have registered.

} catch (SQLException up) {
    throw up;  //haha!
} finally {
    //Silently close off
    if (callableStatement != null) {
        callableStatement.close();
    }

    if (dbConnection != null) {
        dbConnection.close();
    }
}