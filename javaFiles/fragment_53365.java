private String getElement(int row, int col) {
    String result = null;
    String query = "SELECT * from A where row=? and col=?";
    try {
        PreparedStatement preps = con.prepareStatement(query);
        preps.setInt(1, row);
        preps.setInt(2, col);
        preps.execute();
        rs = preps.getResultSet();
        if (rs.next()) {
            result = rs.getString("content");
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }

    return result;
}