Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);

String query = "INSERT INTO session (sessionTimestamp,countryCode,countryName,visitorID) values(?,?,?,?)";

PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, timeStamp);
            preparedStmt.setString (2, countryCode);
            preparedStmt.setString (3, countryName);
            preparedStmt.setString (4, visitorID);

preparedStmt.execute();