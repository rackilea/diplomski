Statement statement1 = connection.createStatement();
    Statement statement2 = connection.createStatement();

    ResultSet resultSet1 = statement1.executeQuery("select * from list");
    while(resultSet1.next()){
        String name = resultSet1.getString("Name");

        ResultSet resultSet2 = statement2.executeQuery("select * from List_Participant where name= '"+name+"'");
        while(resultSet2.next()){
            // get the participants
        }
    }