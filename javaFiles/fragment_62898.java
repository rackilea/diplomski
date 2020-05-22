String whereClause = " WHERE Id = ?";

String insert = "INSERT INTO [Table](C1, C2) VALUES(?, ?)";
String select = "SELECT * FROM [Table] ";
String update = "UPDATE [Table] SET C1 = ? ";
String delete = "DELETE FROM [Table] ";

PreparedStatement insertSt = con.prepareStatement(insert);
PreparedStatement selectSt = con.prepareStatement(select + whereClause);
PreparedStatement deleteSt = con.prepareStatement(update + whereClause);
PreparedStatement updateSt = con.prepareStatement(delete + whereClause);