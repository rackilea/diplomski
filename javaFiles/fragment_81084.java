try (Connection con = DatabaseService.getConnection()) {
    try {
        con.execute(...);
    } catch (Exception e) {
        con.rollback();
    }
}