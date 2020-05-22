public void purchased(int qtyPurchased) throws SQLException {
    // TODO: Update the ProductsDB table's quantity for this
    // object's product code.
    try (Connection conn = SimpleDataSource.getConnection()) {
        try (PreparedStatement stat = conn.prepareStatement(
                (UPDATE ProductsDB SET Quantity = Quantity + ? WHERE Product_Code = ?)) {
            stat.setInt(1, qtyPurchased);
            stat.setString(2, productCode);
            stat.execute();
        }
    }

}