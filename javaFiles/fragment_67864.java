try {
    conn = ds.getConnection();
}
catch (SQLException e) {
    throw new RuntimeException("Something really bad happened, and it makes no sense to continue further, so I'll throw a runtime exception wrapping the original cause", e);
}