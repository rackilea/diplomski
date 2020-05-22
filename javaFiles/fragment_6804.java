if (name != null && name.length() > 0) {
    PreparedStatement ps = connection.prepareStatement(
                           "SELECT * FROM students WHERE Name = ?"); // ? = placeholder
    ps.setString(1, name); // Bind the value to the placeholder
    rs = ps.executeQuery(); // Execute the prepared statement and fetch results
}