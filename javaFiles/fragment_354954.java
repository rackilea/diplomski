int lastRowRead = 0; // starts as 0 when the program starts
//...all your original code here
ResultSet rs = stmt.executeQuery("...LIMIT "+ lastRowRead +",20;");
if(rs.next()!=false) {
    fname = rs.getString("name");
    //...all your original code here
    email.setText(mail);     
}