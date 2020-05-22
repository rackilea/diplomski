query = "insert into invoiceOrders (productCode,quantity,amount) values (?,?,(select price from priceTable where proCode=?))";
PreparedStatement stmt = conn.prepareStatement(query);
stmt.setString(1,"productCode");
stmt.setString(2,"qty");
stmt.setString(3,pCode);  // or stmt.setInt(3,pCode);
n = stmt.executeUpdate();