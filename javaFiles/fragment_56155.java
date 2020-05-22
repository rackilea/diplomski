public Player loadPlayer(String plrName) {
    final String loadStmt = "SELECT * FROM PLAYER WHERE PLAYERNAME = ?";
    try (Connection con = connectToDatabase()) {
        try (PreparedStatement pstmt = con.prepareStatement(loadStmt)) {
            pstmt.setString(1, plrName);
            try (ResultSet rs = pstmt.executeQuery(loadStmt)) {
                if (!rs.next()) {
                    throw new SQLException("Player does not exist: " + plrName);
                }
                Player p = new Player("",0,Boolean.FALSE,"",0,0);
                p.playerName = rs.getString("PLAYERNAME");
                p.totPlayerGoals = rs.getInt("PLAYERGOALS");
                p.totYellowCards = rs.getInt("YELLOWCARDS");
                p.totRedCards = rs.getInt("REDCARDS");
                p.totGamesAsCap = rs.getInt("GAMESASCAP");
                p.positionNum[0] = rs.getInt("FORWARD");
                p.positionNum[1] = rs.getInt("CENTER");
                p.positionNum[2] = rs.getInt("BACK");
                return p;
            }
        }
    } catch(SQLException error) { 
        System.err.println("Error connecting to database: " + error.getMessage());
        throw new IllegalStateException("Loading player", error);
    } 
}