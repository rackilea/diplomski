public void doSomeUpdate() {
    ConnectionHelper.doWithConnection(connection -> {
        PreparedStatement statement = connection.prepareStatement(
                "Insert into db values (NULL ,?,?,?,?,?, NULL , ?)",
                Statement.RETURN_GENERATED_KEYS);
        statement.executeUpdate();
    });
}