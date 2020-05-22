String sql = "SELECT count(*) count" +
              " FROM apps.fnd_user fu" +
             " WHERE UPPER(fu.user_name) LIKE ?";
try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    stmt.setString(1, "ADMIN_" + companyName);
    try (ResultSet rs = stmt.executeQuery()) {
        // code here
    }
}