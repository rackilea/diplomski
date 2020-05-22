PreparedStatement s = connection.prepareStatement("SELECT * FROM customer WHERE name=? AND date=?");
s.setString(1, name.getText());
s.setString(2, day.getText());
ResultSet result = s.executeQuery ();
if(result.next()) {
    // dupilcate records present. don't add
} else {
    // add records to table.
    s.executeUpdate("INSERT INTO customer values ('"+name.getText()+"', '"+day.getText()+"')");
}