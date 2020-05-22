try (Connection conn = new Connection(); 
     Statement statement = connection.createStatement()) {

    // statement.set(....)

    try (ResultSet rs = conn.execute()) {
        // do stuff with rs
    }

} catch (SQLException e) {
    // handle exceptions
}