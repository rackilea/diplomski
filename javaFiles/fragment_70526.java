PreparedStatement stmt = conn.prepareStatement(
    "INSERT INTO items (title, info, URL, image) VALUES (?, ?, ?, ?)"
);
stmt.setString(1, newtitle);
stmt.setString(2, newInfo);
stmt.setString(3, newUrl);
stmt.setString(4, newtitle);
stmt.executeUpdate();