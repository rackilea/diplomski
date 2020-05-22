final PreparedStatement[] stmt = new PreparedStatement[1];
final int i = (Integer)getJdbcTemplate().query(new PreparedStatementCreator() {
    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        stmt[0] = connection.prepareStatement("select max(gameid) from game");
        return stmt[0];
    }
}, new ResultSetExtractor() {
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        return resultSet.getString(1);
    }
});