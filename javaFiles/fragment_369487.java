statement.executeUpdate();
    ResultSet generatedKeys = statement.getGeneratedKeys();
    long generatedId= 0L;
    if (generatedKeys.next()) {
        generatedId = generatedKeys.getLong(1);// here is your generated Id , 
    }