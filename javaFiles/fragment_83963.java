public List<DbStudent> getStudents() throws ClassNotFoundException, SQLException {
    List<DbStudent> entries = new ArrayList<DbStudent>();

    Class.forName(databaseDriver);
    this.connection = DriverManager.getConnection(connectionString);

    Statement sttm = this.connection.createStatement();
    ResultSet rs = sttm.executeQuery("select * from TMP_STUDENT"); //in your case procedure call

    if (rs != null) {
        while (rs.next()) { //add the results into the list
            entries.add(new DbStudent(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getInt("ID"),
                                      rs.getString("SUB"), rs.getString("PERCENT")));

        }
        rs.close();
    }

    return entries;
}