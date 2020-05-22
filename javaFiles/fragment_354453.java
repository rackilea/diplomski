try (PreparedStatement stm = con.prepare...) {
    stm.setString(1, "me");
    try (ResultSet rs = stm.executeQuery()) {
        while (rs.next()) {
            ...
        }
    }
}