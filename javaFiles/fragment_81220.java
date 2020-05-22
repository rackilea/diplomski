ResultSet res = stmt.executeQuery("SELECT * FROM sometable");

while (res.next()) {
    res.getString(1);

    // Closes the previous `ResultSet`
    res = stmt.executeQuery("SELECT * FROM othertable");
}