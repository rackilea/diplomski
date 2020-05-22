String name = "shadrach"
Double price = "100.00"
int qty = 3;
    String template = "INSERT INTO PRODUCT (NAME,PRICE,QTY) values (?,?,?)";
                PreparedStatement stmt = connection.prepareStatement(template);
                stmt.setString(1, name);
                stmt.setDouble(2, price);
                stmt.setInt(3, qty);
                stmt.executeUpdate();