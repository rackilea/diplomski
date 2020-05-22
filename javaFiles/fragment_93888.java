DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        // constructs SQL statement
        String sql = "INSERT INTO tablename(columnname) values (?)";
        PreparedStatement statement = conn.prepareStatement(sql);             
        if (inputStream != null) {
            // fetches input stream of the upload file for the blob column
            statement.setBlob(1, inputStream);
        }

        // sends the statement to the database server
        int row = statement.executeUpdate();
        if (row > 0) {
            message = "File uploaded and saved into database";
        }