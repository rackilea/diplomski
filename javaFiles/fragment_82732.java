KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
jdbcTemplate.update(new PreparedStatementCreator() {
    @Override
    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("Your Insert/Update Query", Statement.RETURN_GENERATED_KEYS);
        // set values in query
        return statement;
    }
}, generatedKeyHolder);

Number id = generatedKeyHolder.getKey();
// Use this Number to get id with feasible type long, int etc.
// For example,
// int myId = id.intValue();