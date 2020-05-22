Connection conn = /*defined elsewhere*/;
String name = /*defined elsewhere*/;

int id;
String sql = "select ID from MyTable where Name = ?";
try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    stmt.setString(1, name);
    try (ResultSet rs = stmt.executeQuery()) {
        if (! rs.next())
            throw new IllegalArgumentException("Not found: " + name);
        id = rs.getInt("ID");
        if (rs.next())
            throw new IllegalArgumentException("Multiple rows found: " + name);
    }
}
System.out.println(id); // Yay!