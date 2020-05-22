PreparedStatement ps = conn.prepareStatement("insert into employees(socialSecurityNumber, firstName, lastName, birthday, employeeType, departmentName) "
    + "values (?, ?, ?, ?, ?, ?)");
ps.setInt(1, socialSecurityNumber);
ps.setString(2, firstName);
...
ps.executeUpdate();