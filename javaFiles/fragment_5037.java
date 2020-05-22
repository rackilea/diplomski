//... boilerplate
try (Connection conn = ConnectionFactory.getConnection()) {
    try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM MYTABLE WHERE COL=?")) {
        ps.setString(1, "val");
        try (ResultSet rs = ps.executeQuery()) {
            // ... more
        }
    }

    try (PreparedStatement ps = conn.prepareStatement("UPDATE MYTABLE SET COL=?")) {
        // ... etc
    }
}