PreparedStatement ps = null;
try {
    ps = mySQL.getConnection()        
        .prepareStatement("SELECT 1 FROM playerinfo WHERE Username = ? LIMIT 1");
    ps.setString(1, player.getName()); 
    ResultSet rs = ps.executeQuery();

    // the first invocation of rs.next() returns true if 
    // there are rows in the result set, or false if no rows were found
    if (rs.next()) {
        System.out.println("2");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED 
            + "Player already in database");
    }        
    rs.close();
} finally {
    if (ps != null) {
        ps.close();
    }
}