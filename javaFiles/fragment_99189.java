String insertTableSQL = "INSERT INTO Leden"
        + "(A,B,C,D) VALUES"
        + "(?,?,?,?)";

preparedStatement.setInt(1, 11);
preparedStatement.setString(2, "Hello");
preparedStatement.setString(3, "this");
preparedStatement.setString(4, "OP");]

preparedStatement .executeUpdate();