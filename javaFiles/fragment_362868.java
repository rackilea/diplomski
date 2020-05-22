private Person extractUserFromResultSet(ResultSet rs) throws SQLException { 

    // add this line below
    Person person = new Person();

    person.setId(rs.getInt("ID"));
    person.setFName(rs.getString("FName")); 
    person.setLName(rs.getString("LName")); 
    person.setDOB(rs.getString("DOB")); 
    person.setDepartment(rs.getString("Department")); 
    person.setLocation(rs.getString("Location")); 
    person.setCellNr(rs.getString("Cellnr")); 
    person.setUsername(rs.getString("Username")); 
    person.setPassword(rs.getString("Password"));
    return person;
}