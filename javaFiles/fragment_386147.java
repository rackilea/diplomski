try (
     Connection connection = getConnection();
     PreparedStatement preparedItemsStatement = connection.prepareStatement(myQuery);
    ) {
        preparedItemsStatement.setString(1, userId + "%");
        try (ResultSet rs = preparedItemsStatement.executeQuery()) {
           ...