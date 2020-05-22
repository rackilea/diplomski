public List<String> computeGPA(String studentId) throws SQLException {
    String sql = "SELECT gpa FROM student WHERE sid=?";
    try (Connection con = connect();
            PreparedStatement pstmt = con.prepareStatement(sql)) {
        pstmt.setString(1, studentId);
        try (ResultSet rst = pstmt.executeQuery()) {
            List<String> gpas = new ArrayList<>();
            while (rst.next()) {
                gpas.add(rst.getString(1));
            }
            return gpas;
        }
    }
}