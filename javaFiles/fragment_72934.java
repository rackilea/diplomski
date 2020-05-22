String number, key;
PreparedStatement ps = conn.prepareStatement("select count(*) "
                                           + "from users_transition "
                                           + "where phoneNumber=? "
                                           + "  and randKey=?");
// The question marks are place holders for values
// You can assign this values with setXXX() methods
ps.setString(1, number);
ps.setString(2, randKey);
ResultSet rs = ps.executeQuery();
// Do whatever you need to do with the ResultSet