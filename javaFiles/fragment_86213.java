PreparedStatement preparedStatement;
    ResultSet resultSet;
    String query = "select * from employee where username = ? and password = ?";

    try {
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user);
        preparedStatement.setString(2, pass);

        resultSet = preparedStatement.executeQuery();


        if (resultSet.next()) {
            preparedStatement.close(); // after closing this, it works
            resultSet.close();         // closed this one also
            return true;
        } else {
            return false;
        }


    } catch (Exception e) {
        // TODO: handle exception
        return false;
    }