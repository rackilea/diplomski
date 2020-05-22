ResultSet rs = stmt.executeQuery("your SQL statement here");
while (rs.next()) {
    fname = rs.getString("name");
    //...all your original code here
    email.setText(mail);     
}