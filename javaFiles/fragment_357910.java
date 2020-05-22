catch (DataAccessException e) {
    if (e.getCause() instanceof SQLException &&
       ("40001".equals(((SQLException) e.getCause()).getSQLState()))) {
        ...
    }
}