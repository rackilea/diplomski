public void doStuff() {
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(
            new PreparedStatementCreator() {
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement ps = connection.prepareStatement("insert into test(val) values (?)", Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, 42);
                    return ps;
                }
            },
            keyHolder);

    keyHolder.getKeys().get("id");
    keyHolder.getKeys().get("otherid");
}