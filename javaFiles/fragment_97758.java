try (Connection dbConnection = getConnection();
     PreparedStatement preparedStatement = dbConnection.preparedStatement(...)) {

  ... bind variables to preparedStatement ...

  try (ResultSet rs = preparedStatement.executeQuery()) {

    ... work with result set ...
  }
}