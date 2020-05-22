public void updateTable() throws ClassNotFoundException, SQLException {
 String sql = "select * from instruments_sales_t where sold = 'YES'";
 conn = ConnectionToDb.connectDb();
 stmt = conn.createStatement();
 rs = stmt.executeQuery(sql);


 DefaultTableModel model = new DefaultTableModel() {
 public Class<?> getColumnClass(int column) {
 switch (column) {

 case 0: return String.class;
 case 1: return String.class;
 case 2: return String.class;
 case 3: return String.class;
 case 4: return String.class;
 case 5: return String.class;
 case 6: return String.class;
 case 7: return Boolean.class;

 default:return String.class;
 }
 }
 };


 tablePaidSales.setModel(model);
 model.addColumn("id");
 model.addColumn("Name");
 model.addColumn("Size");
 model.addColumn("Avail");
 model.addColumn("Total");
 model.addColumn("Cl");
 model.addColumn("Date");
 model.addColumn("");

 int i = 0;
 while (rs.next()) {
 model.addRow(new Object[0]);
 model.setValueAt(rs.getString("id"), i, 0);
 model.setValueAt(rs.getString("name"), i, 1);
 model.setValueAt(rs.getString("size"), i, 2);
 model.setValueAt(rs.getString("want_items"), i, 3);
 model.setValueAt((rs.getDouble("want_price"))*(rs.getDouble("want_items")), i, 4);
 model.setValueAt(rs.getString("client"), i, 5);
 model.setValueAt(rs.getString("date_of_sell"), i, 6);
 model.setValueAt(false, i, 7);
 i++;
 }

      DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
      rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
 rightRenderer.setForeground(Color.BLUE);

 DefaultTableCellRenderer redRenderer = new DefaultTableCellRenderer();
 redRenderer.setHorizontalAlignment(JLabel.RIGHT);
 redRenderer.setForeground(Color.RED);

 tablePaidSales.setShowGrid(true);
 tablePaidSales.setGridColor(Color.LIGHT_GRAY);
 tablePaidSales.setShowHorizontalLines(false);
 tablePaidSales.getColumnModel().getColumn(0).setPreferredWidth(28);
 tablePaidSales.getColumnModel().getColumn(1).setPreferredWidth(230);
 tablePaidSales.getColumnModel().getColumn(2).setPreferredWidth(140);
 tablePaidSales.getColumnModel().getColumn(3).setPreferredWidth(57);
 tablePaidSales.getColumnModel().getColumn(4).setPreferredWidth(70);
 tablePaidSales.getColumnModel().getColumn(5).setPreferredWidth(120);
 tablePaidSales.getColumnModel().getColumn(6).setPreferredWidth(82);
 tablePaidSales.getColumnModel().getColumn(7).setPreferredWidth(25);
 tablePaidSales.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
 tablePaidSales.getColumnModel().getColumn(4).setCellRenderer(redRenderer);
 }