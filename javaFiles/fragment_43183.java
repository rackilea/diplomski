PreparedStatement statement = connection.prepareStatement(
            "INSERT INTO flights (flightID,departure,arrival)
               VALUES(?,?,?)");
        statement.setString(1,flightID);
        statement.setString(2,departure);
        statement.setString(3,arrival);
        statement.executeUpdate();

        // thanks to @lobster1234 for reminder!
        connection.commit();