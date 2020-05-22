try (PreparedStatement ps = getSQLDB().prepareStatement(
        "INSERT INTO student(....) VALUES(?, ..., ?)",
        Statement.RETURN_GENERATED_KEYS)) { // Without StudentId
    ps.setString(1, name);
    ...
    ps.executeUpdate();


    try (ResultSet rsKeys = ps.getGeneratedKeys()) {
        if (rsKeys.next()) { // Only one record inserted
            int studentId = rsKeys.getInt(1); // One key generated
        }
    }
} catch (SQLException e){
    Logger.getLogger(Undergraduate.class.getName()).log(Level.SEVERE, null, e);
}