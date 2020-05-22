Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","user","pass");
    Statement myStmt = myConn.createStatement();
    ResultSet myRs = myStmt.executeQuery("SELECT MAX(ID) as my_max_val FROM table");

    myRs.next(); //you might also have forgotten this
    int i = myRs.getInt("my_max_val")+1;
    System.out.println(i);