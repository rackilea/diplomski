try (PreparedStatement ps = conn.prepareStatement(
         "INSERT INTO orders(id, order_number) VALUES (NEXT VALUE FOR seq1, ?)",
         new String[] { "id" })) {
    ps.setString(1, order.getOrderNumber());
    ps.execute();

    try (ResultSet rs = stmt.getGeneratedKeys()) {
        if (rs.next()) {
            return rs.getLong(1);
        }
    }
}