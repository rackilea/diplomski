public void RegisterNewUser(String username, String password, String firstname, String surname, String dateOfBirth, int currentWeight) {

    //This code will connect the database to the java program

    Connection myconObj = null; //allows to connect to database
    ResultSet myresObj = null; // get result
    ResultSetMetaData mymeta = null;

    try {

        String query = "INSERT INTO JACOVANSTRYP.MAINUSERDATA(USERNAME, PASSWORD, FIRSTNAME, LASTNAME, DATEOFBIRTH, CURRENTWEIGHTKG, ACTIVEPOINTS) VALUES(?,?,?,?,?,?,?)";

        myconObj = DriverManager.getConnection("jdbc:derby://localhost:1527/MainUserData", "jacovanstryp", "Eduplex1234");
        PreparedStatement add = myconObj.prepareStatement(query);
        add.setString(1, username);
        add.setString(2, password);
        add.setString(3, firstname);
        add.setString(4, lastname);
        add.setString(5, dateOfBirth); // might need setDate() depending on your table structure
        add.setString(6, currentWeight);
        add.setString(7, "0");
        add.executeUpdate();
        mymeta = myresObj.getMetaData();
        System.out.println("User Successfuly created");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}