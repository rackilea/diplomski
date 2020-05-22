if (!isPatent(connection, preparedstatement, name)) 
    addpatient(connection, preparedstatement, name, age, height, weight);



    public static boolean isPatient(Connection connection,
            PreparedStatement preparedstatement, String name)
            throws SQLException {
        boolean exists = false;
        preparedstatement = connection
                .prepareStatement("select * from allpatients where name = ?");

        preparedstatement.setString(1, name);
        ResultSet rs = preparedstatement.executeQuery();
        if (rs.next()) {
            exists = true;
        }
        rs.close();
        return exists;
    }