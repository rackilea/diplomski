private static final String GET_USERS_BY_PARAMS = "select * from user t "
    + "where t.id like ? "
    + "AND t.name LIKE ? "
    + "AND t.location LIKE ? " 
    + "AND t.telephone LIKE ? ";

statement = connection.prepareStatement(GET_USERS_BY_SEARCH_PARAMS);
statement.setString(1, "%" + userID + "%");
statement.setString(2, "%" + name + "%");
statement.setString(3, "%" + location + "%");
statement.setString(4, "%" + telephone() + "%");