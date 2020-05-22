String SQL_1 = "insert into talkview(titlename,postname) values(? , ?)";
    String SQL_2 = "insert into maintalk(title,text,username,talk_id) values(? , ? , ?, ?)";
    String SQL_3 = "SELECT id FROM talkview order by id DESC LIMIT 1;";
    try {
        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_1);
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, name);
        Integer a = preparedStatement.executeUpdate();

        // This is the query to retrieve the last ID you insert in talkveiw table
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_3);
        ResultSet result = preparedStatement.executeQuery();
        Integer id = 0; // This will be the id you will add on your talk_id
        if(result.next()) {
            id = result.getInt(1);
        }

        preparedStatement = connection.prepareStatement(SQL_2);
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, con);
        preparedStatement.setInt(4, id); // you will insert it here the 'id'
        Integer b = preparedStatement.executeUpdate();
        connection.commit();
        connection.setAutoCommit(true);