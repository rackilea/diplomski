Session session = em.unwrap(Session.class);
Integer bookCount = session.doReturningWork(new ReturningWork<Integer>() {

    @Override
    public Integer execute(Connection con) throws SQLException {
        // do something useful
        try (PreparedStatement stmt = con.prepareStatement("SELECT count(b.id) FROM Book b")) {
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }
});

log.info("Found " + bookCount + " books.");