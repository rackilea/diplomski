public void doGet (HttpServletRequest request, HttpServletResponse response) 
  throws IOException, ServletException {
    String driverName = "com.mysql.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost/";
    String dbName = "db";
    String userId = "root";
    String password = "root";

    try {
       Class.forName(driverName);
     } catch (ClassNotFoundException e) {
          e.printStackTrace();
    }

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null; 
    try{ 
    connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
    statement=connection.createStatement();
    String sql ="SELECT * FROM table";
    resultSet = statement.executeQuery(sql);
    // Now convert this result set into a class having field id and data..
    // like MyClass{ String id; String data;}
    // make a list of List<MyClass>list = new ArrayList<>();
    request.setAttribute("list",list); 
    this.getServletContext().getRequestDispatcher("/jsp/yourPageName.jsp").
   include(request, response);
 }