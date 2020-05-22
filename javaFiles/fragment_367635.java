String name = View.searchname.getText();
String plz = View.searchplz.getText();

// Use :<name> for parameters
String result = "SELECT BBSTBBNR, BBSTNABEG, BBSTPLZ FROM BP.TBBBST " + 
        " WHERE BBSTNABEG = :name AND BBSTPLZ = :plz";

DB2PreparedStatement preparedStatement = (DB2PreparedStatement) dbConnection.prepareStatement(result);

// Set values for parameters
preparedStatement.setJccStringAtName("name", name);
preparedStatement.setJccStringAtName("plz", plz);