ResultSet res = statement.executeQuery("SELECT * FROM tokens WHERE PlayerName = '" + name + "';");

int tokens = 0;

if (res.next()) {
    Statement statement = connection.createStatement();
    statement.executeUpdate("INSERT INTO tokens (`PlayerName`, `tokens`) VALUES ('" + name + "', '0');");

    tokens = 1000;
} else {
    tokens = res.getInt("tokens");
}