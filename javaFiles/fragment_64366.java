public static void main(String[] args) {
    String connectionURL = "jdbc:sqlite:C:/__tmp/cities.db";
    try (Connection conn = DriverManager.getConnection(connectionURL)) {
        String sql = "SELECT Country FROM CITIES";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String s = new String(rs.getBytes(1), "cp437");
                    System.out.println(s);
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace(System.err);
    }       
}