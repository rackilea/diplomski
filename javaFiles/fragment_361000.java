try (PreparedStatement ps = con.prepareStatement("INSERT INTO chessleague.table1 (FName , SName , DOB) VALUES (?, ?, ?)")) {
    ps.setString(0, fName);
    ps.setString(1, sName);
    ps.setString(2, DOB);
    ps.execute();
} catch (SQLException ex) {
    System.out.println("SQLException: " + ex.getMessage());
}