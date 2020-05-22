PreparedStatement pstmt = (PreparedStatement) con.prepareStatement("insert into product(productID,description,quantity,price,discount) values(?,?,?,?,?)");
           pstmt.setString(1, productId);
           pstmt.setString(1, desc);
           //same for all statement
           pstmt.executeUpdate();
           pstmt.close();