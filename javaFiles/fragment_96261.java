public boolean isEveryTransactionNotClosed (String txIds) throws QiibException {
        String sql = "<Query> ";
        logger.info("isEveryTransactionNotClosed SQL :"+sql);
        try {
            final boolean isEveryDealNotClosed =  getJdbcTemplate().queryForObject(sql, new Object[] {dealIds}, 
                    new RowMapper<Boolean>()  {
                    public Boolean mapRow(ResultSet rs, int rowNum) throws SQLException {
                        if (!rs.next()) {
                            isEveryTransactionNotClosed = false;    -->                         
                        }
                    }
            });
        } catch(EmptyResultDataAccessException e) {
            logger.error("Empty result data - isEveryTransactionNotClosed ");   
        }
       return isEveryTransactionNotClosed ;
    }