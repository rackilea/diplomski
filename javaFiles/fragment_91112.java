//use ? for parameter placeholder
    String sql = "INSERT INTO \"Reservations\"(\r\n" + 
            "   \"Last\", \"First\", \"Day\")\r\n" + 
            "   VALUES (?, ?, ?);";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, last);
    preparedStatement.setString(2, first);
    preparedStatement.setString(3, day);
    preparedStatement.execute();