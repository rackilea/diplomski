ResultSet guilds = qGStmt.executeQuery("SELECT * FROM guilds;");
while(guilds.next()) {
    localInDb.add(guilds.getString("guild_uid").toLowerCase());
}
System.out.println("Queried: " + localInDb.size());
this.guildsInDb = localInDb;