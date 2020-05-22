protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    out = response.getWriter();
    response.setContentType("text/html");


    // JDBC driver name and database URL
       final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
       final String DB_URL = "jdbc:mysql://hostname:port/test";

       //  Database credentials
       final String USER = "username";
       final String PASS = "password";


       java.sql.Connection conn = null;
       java.sql.Statement stmt = null;

          //STEP 2: Register JDBC driver
          try {
            Class.forName(JDBC_DRIVER);


          //STEP 3: Open a connection
          System.out.println("Connecting to a selected database...");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

          System.out.println("Connected database successfully...");

          //STEP 4: Execute a query
          System.out.println("Creating statement...");

            stmt =conn.createStatement();


          String sql = "SELECT name FROM table1";
          ResultSet rs = null;

            rs = stmt.executeQuery(sql);

          //STEP 5: Extract data from result set

            while(rs.next()){
                 //Retrieve by column name

                 String name = rs.getString("name");

                 //Display values
                 System.out.print("Name: " + name);
                 out.println("<input type=\"text\" name=\"last_name\" value = "+name+">"+"</input>");
              }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


}