String sql = 
        "SET NOCOUNT ON; " +
        "DECLARE @upd INT; " +
        "EXEC dbo.usp_assignPartToShelf " + 
                "@p_ItemNumber=?, " + 
                "@p_ShelfNumber=?, " + 
                "@p_UpdatedItems=@upd OUTPUT, " + 
                "@p_DoerTicket=?;" +
        "SELECT @upd AS UpdatedItems;";
try (PreparedStatement s = conn.prepareStatement(sql)) {
    s.setString(1, "testItemNumber");
    s.setString(2, "testShelfNumber");
    s.setString(3, "testDoerTicket");
    ResultSet rs = s.executeQuery();  // above T-SQL always returns at least one ResultSet
    rs.next();
    System.out.println(rs.getString(1));  // display something from ResultSet
    if (s.getMoreResults()) {
        System.out.printf(
                "INFO:%n" + 
                "  A second ResultSet was found.%n" + 
                "  The previous ResultSet was returned by the stored procedure.%n" + 
                "  Getting next ResultSet ...%n", 
                "");
        rs = s.getResultSet();
        rs.next();
        System.out.println(rs.getString(1));
    }
    rs.close();
}