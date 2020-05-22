String url = "jdbc:derby://localhost:1527/Database";

    try{Class.forName("org.apache.derby.jdbc.ClientDriver"); //... set the driver  
    con = DriverManager.getConnection(url,"username","password");
     stmt = con.createStatement();
     System.out.println("Connected!");
    }catch(Exception q){System.out.println("Not connected!");