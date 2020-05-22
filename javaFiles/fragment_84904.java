public void write(List<Users> users) throws Exception {
    String updateQuery = "update users set ddp_created_fl=? where email=?";

    jdbcTemplate.batchUpdate(updateQuery,
                new BatchPreparedStatementSetter() {

                    public void setValues(PreparedStatement ps, int i) 
                        throws SQLException {
                        ps.setLong(1, 1);
                        ps.setString(2, users.get(i).getEmail());
                    }

                    public int getBatchSize() {
                        return users.size();
                    }

                });
}