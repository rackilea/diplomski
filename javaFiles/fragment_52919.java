preparedStmt.setString(1, "JDBC");    // so JDBC is your category ?
preparedStmt.setString(2, fileField.getText()); // I guess this should be the question?
preparedStmt.setString(3, "a");       // according to the column names this needs to be option A
preparedStmt.setString(4, "b");       // option b
preparedStmt.setString(5, "c");       // option c
preparedStmt.setString(6, "d");       // option d
preparedStmt.setString(7, "a");       // answer