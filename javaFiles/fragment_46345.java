try {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost/database", "root", "root");
         Statement stmt = con.createStatement();

        // perform required operation

 } catch (Exception e) {
            System.out.println(e);
   }