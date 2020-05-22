try (PreparedStatement s = connection.prepareStatement(
    "INSERT INTO asset (type_id, purchase_price, purchased_at) " +
    "SELECT id, ?, ? " +
    "FROM cars.asset_type " +
    "WHERE asset_type.name = ?")) {

    s.setDouble(1, parseDouble(purchased.getText()));
    s.setDate(2, Date.valueOf(purchased_at.getValue()));
    s.setString(3, sellables.getValue());
}