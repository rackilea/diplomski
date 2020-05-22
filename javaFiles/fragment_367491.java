public boolean doSomeQuery() {
    return ConnectionHelper.doWithConnection(connection -> {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM table");
        return statement.execute();
    });
}