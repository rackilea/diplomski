String name = View.searchname.getText();
String plz = View.searchplz.getText();

// Use ? for parameters
String result = "SELECT BBSTBBNR, BBSTNABEG, BBSTPLZ FROM BP.TBBBST " + 
        " WHERE BBSTNABEG = ? AND BBSTPLZ = ?";

preparedStatement = dbConnection.prepareStatement(result);

// Set values for parameters
preparedStatement.setString(1, name);
preparedStatement.setString(2, plz);