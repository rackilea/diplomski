Connection conn = null;

       try {
           String userName = "myuser";
           String password = "mypassword";
           String url = "jdbc:mysql://localhost:3306/mydb";
           Class.forName ("com.mysql.jdbc.Driver").newInstance ();
           conn = DriverManager.getConnection (url, userName, password);
       } catch (Exception e) {
           System.err.println ("Cannot connect to database server");
       }