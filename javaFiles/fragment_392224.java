PreparedStatement ps = con.prepareStatement(
        "DELETE c.*, p.*, m.* " +
        "FROM " +
            "(" +
                "customer_details AS c " +
                "INNER JOIN " +
                "papers AS p " +
                    "ON p.customer_id=c.customer_id " +
            ")" +
            "INNER JOIN " +
            "magzines AS m " +
                "ON m.customer_id=p.customer_id " +
        "WHERE c.customer_id=?");   
ps.setString(1,tx1.getText());
int n = ps.executeUpdate();