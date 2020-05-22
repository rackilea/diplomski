try (Connection conn = yourCodeToGetConnection();
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery(query)) {
    while (rs.next()) {
        String coffeeName = rs.getString("COF_NAME");
        int supplierID = rs.getInt("SUP_ID");
        float price = rs.getFloat("PRICE");
        int sales = rs.getInt("SALES");
        int total = rs.getInt("TOTAL");

        System.out.println(coffeeName + ", " + supplierID + ", " + 
                               price + ", " + sales + ", " + total);
    }
} catch (SQLException ex) {
    // log, report or raise
}