String searchQuery = "select NodesThatJustPinged from JustPinged where NodesThatJustPinged = '" + nodeInfo + "'";
    Statement searchToEliminateDuplicates = connection.createStatement();
    ResultSet duplicateExists = searchToEliminateDuplicates.executeQuery(searchQuery);

    if(duplicateExists.next()) {
        // update the LastPingedAt column in the JustPinged table 
        String updateQuery = "update JustPinged set LastPingedAt='" + pingedAt + "' where NodesThatJustPinged = '" + nodeInfo + "'";
        PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
        updateStatement.executeUpdate();System.out.println("If statement");
    } else {
        // make a new entry into the database
        String newInsertionQuery = "insert into JustPinged values('" + nodeInfo + "','" + pingedAt + "')";
        PreparedStatement insertionStatement = connection.prepareStatement(newInsertionQuery);
        insertionStatement.executeUpdate();System.out.println("else statement");              
      }