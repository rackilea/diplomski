PreparedStatement stmt = conn.prepareStatement(sql, 
                                 Statement.RETURN_GENERATED_KEYS);
// ...

ResultSet res = stmt.getGeneratedKeys();
while (res.next())
    System.out.println("Generated key: " + res.getInt(1));