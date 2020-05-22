public String getBugList(int amount) {
    Connection con  = DatabaseConnection.getConnection();
    String query = "SELECT submitter, report FROM bugs_log ORDER BY id DESC limit ?";
    try(PreparedStatement ps = con.prepareStatement(query)) {
        ps.setInt(1, amount);
    }
}