String sql = "SELECT * FROM table1 WHERE Surname LIKE ? OR ";
sql +=       "Middlename LIKE ? OR Firstname LIKE ?";
PreparedStatement statement = con.prepareStatement(sql);
statement.setString(1, "%" + key + "%");
statement.setString(2, "%" + key + "%");
statement.setString(3, "%" + key + "%");