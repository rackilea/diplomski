preparedStatement = connection.prepareStatement("INSERT INTO data (default, description, .., ....) VALUES (?, ?, ?, ?)");
preparedStatement.setInt(1,0);
preparedStatement.setString(2, data.getDescription());
preparedStatement.setTimestamp(3, ...);
.....

preparedStatement.executeUpdate();