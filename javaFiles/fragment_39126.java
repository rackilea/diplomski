String sql = "UPDATE employees set firstName = ?, lastName = ?, gender = ?, ";
sql += "age = ?, position = ?, image = ? where employeeNum =?";

pst.setString(1, firstName);  // first parameter (?) in statement
pst.setString(2, lastName);
pst.setString(3, gender);
pst.setInt(4, age);
pst.setString(5, position);
pst.setString(6, image);
pst.setInt(7, employeeNum);   // LAST parameter (?) in statement