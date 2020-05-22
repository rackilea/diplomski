Session session = entityManager.unwrap(Session.class);
final AtomicLong resultHolder = new AtomicLong();
session.doWork(connection -> {
    try(PreparedStatement statement = connection.prepareStatement("INSERT INTO post VALUES (?) select scope_identity() ") ) {
        statement.setString(1, "abc");
        if ( !statement.execute() ) {
            while ( !statement.getMoreResults() && statement.getUpdateCount() != -1 ) {
                // do nothing until we hit the resultset
            }
        }
        try (ResultSet rs = statement.getResultSet()) {
            if(rs.next()) {
                resultHolder.set(rs.getLong(1));
            }
        }
    }
});
assertNotNull(resultHolder.get());