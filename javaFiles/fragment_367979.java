StringBuilder sql = new StringBuilder(
    "UPDATE USERS SET\n"
);

sql.append("USER_TYPE=?,\n")
    .append("FIRST_NAME=?,\n")
    .append("LAST_NAME=?,\n")
   .append("EMAIL_ADDRESS=?\n");
sql.append("WHERE USER_ID=?");

preparedStatement = connection.prepareStatement(sql.toString());

for (User user : updatedUsers) {
        preparedStatement.setString(1, user.getUserTypeId());
        preparedStatement.setString(2, user.getFirstName());
        preparedStatement.setString(3, user.getLastName());
        preparedStatement.setString(4, user.getEmailAddress());
        preparedStatement.setString(5, user.getUserId());
        preparedStatement.addBatch();

        // Submit in batches of 1000
        if (++count % batchSize == 0) {
            rowsAffected += IntStream.of(preparedStatement.executeBatch()).sum();
            preparedStatement.clearBatch();
        }
}