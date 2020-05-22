jdbcTemplate.query("Select * from user where id=?"), new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException
            {
                preparedStatement.setLong(1, id);
            }
        }, new ResultSetExtractor<User>() {
...                
}});