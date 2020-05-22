public static List<List<String>> getAllFabrics() throws SQLException{
    sql = "SELECT * FROM fabric";
    List<List<String>> values = new ArrayList<>();
    stmt = con.createStatement();
    rs = stmt.executeQuery(sql);
    while(rs.next()){
        List<String> row = new ArrayList<>();
        row.add(String.valueOf(rs.getInt("id")));
        row.add(rs.getString("ItemDesc"));
        row.add(rs.getString("Supplier"));
        // Now row contains {id, item, supplier}
        values.add(row);
    }
    return values;
}