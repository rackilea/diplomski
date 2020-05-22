try {
       Class.forName("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/test","root","");
       System.out.println("Connection successful");
 } catch (Exception e) {
       System.err.println(e);
 }