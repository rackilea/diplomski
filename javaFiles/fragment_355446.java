public static HashMap<Integer, String> recentTickets(Player p) throws SQLException {
    rTickets.clear();
    int t = 0;
    Statement statement = MySQL.getConnection().createStatement();
    ResultSet r2 = statement
        .executeQuery("SELECT COUNT(*) FROM tickets ORDER BY Date DESC;");
    while (r2.next()) {
      t = r2.getInt(1);
    }
    if(t>5){
        t=5;
    }

    ResultSet result = statement.executeQuery(
            "SELECT * FROM tickets ORDER BY Date DESC LIMIT " + t + ";");

        for (int i = 0; i < t; i++) {
            result.next();
            rTickets.put(result.getInt("TicketID"), result.getString("UUID"));

        }
        return rTickets;        
}