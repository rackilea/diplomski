try (Connection conn = ) {
    String query = "...";
    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        if (stmt.executeUpdate() == 0) {
            System.err.println("Possible error with update, did not update any rows");
        }
    }
} catch (SQLException exp) {
    exp.printStackTrace();
}