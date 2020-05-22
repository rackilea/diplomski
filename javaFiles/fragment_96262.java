public boolean isEveryTransactionNotClosed (String txIds) throws QiibException {
    String sql = "<Query> ";
    logger.info("isEveryTransactionNotClosed SQL :"+sql);
    boolean isEveryDealNotClosed = true;
    try {
        isEveryDealNotClosed =  getJdbcTemplate().queryForObject(sql, new Object[] {dealIds}, 
                new RowMapper<Boolean>()  {
                public Boolean mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return rs.next();
                }
        });
    } catch(EmptyResultDataAccessException e) {
        logger.error("Empty result data - isEveryTransactionNotClosed ");   
    }
   return isEveryDealNotClosed;
}