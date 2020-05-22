try {
    userRepository.deleteUser(id);

} catch(org.springframework.dao.DataAccessException e) {
    if( e.getRootCause() instanceof SQLException) {
        SQLException sqlEx = (SQLException) e.getRootCause();
        int sqlErrorCode = sqlEx.getErrorCode();
        // do further things from here on...
    }
}