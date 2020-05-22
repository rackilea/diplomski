try (Connection conn = new Connection()) {
    ResultSet rs = conn.execute()
    // do stuff with rs
} catch (SQLException e) {
    // handle exception
}