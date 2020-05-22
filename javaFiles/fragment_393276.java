@Override
void afterPropertiesSet() {
    _logger.debug("Entering setDs")
    _jt = new JdbcTemplate(ds);
    _logger.debut("Exiting setDs);
}