PreparedStatement stmt = conn.prepareStatement(
        "SELECT USERNAME FROM studentsTable WHERE USERNAME = ? AND PASSWORD = ?");
stmt.setString(1, username);
stmt.setString(2, password);
ResultSet rs = stmt.executeQuery();
if (rs.next()) {
    // valid credentials
} else {
    // invalid credentials
}

rs.close();
stmt.close();