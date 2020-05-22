String query = "SELECT * FROM user_stock WHERE cartID="+cartID;
rs = stmt.executeQuery(query);
jInternalFrame1.setVisible(true);
javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
model.setColumnIdentifiers(new String [] {
                              "Product No.", "Product Name", "Product Code", "Product Quantity", "Product Price", "Discount" });
 jTable1.setModel(model);
 while (rs.next()) {
     model.addRow(new Object [] {
               rs.getString("id"), rs.getString("product_name"), rs.getString("product_code"), rs.getString("product_quantity"), rs.getString("product_price"), "0"});       
 }