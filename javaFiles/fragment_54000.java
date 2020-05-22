String s = "select * from users";

// many lines of code
s = "temp";
// do something with s
// many lines of code
PreparedStatement stmt = conn.prepareStatement(sql);