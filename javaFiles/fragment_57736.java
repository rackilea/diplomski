private void tblOrderListMouseClicked(java.awt.event.MouseEvent evt) {
    int raw = tblOrderList.getSelectedRow();
    OrderModel or;
    String item;
    Double qty, amount, total;

    ArrayList<OrderModel> arrOrder = new ArrayList<OrderModel>();

    String selectedRaw = tblOrderList.getModel().getValueAt(raw, 0).toString();
    String sql = "select item,qty,amount from orderdetails where orderid=?";
    con = new DBconnector().connect();
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, selectedRaw);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                or = new OrderModel();
                or.setItem(rs.getString("item"));
                or.setQty(rs.getDouble("qty"));
                or.setAmount(rs.getDouble("amount"));
                arrOrder.add(or);
            }
            OrderTableModel model = new OrderTableModel(arrOrder);
            tblOrderItems.setModel(model);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

}