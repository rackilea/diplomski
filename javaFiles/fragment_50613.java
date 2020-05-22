private Connection connect = null;
  PreparedStatement preparedStatement = null;

 public int save() throws Exception {
   int status = 0;  
    try {
      // Load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");

      // DB connection setup 
      connect = DriverManager.getConnection("jdbc:mysql://dbhost/database?" + "user=sqluser&password=sqluserpw");

      // PreparedStatements 
      preparedStatement = connect
          .prepareStatement("insert into  Table_Name values (?, ?, ?, ? )");

      Object obj = parser.parse(new FileReader("c.\\itemize.json"));
      JSONObject jsonObject = (JSONObject) obj;

      String pr = (String) jsonObject.get("Pr");
      // Parameters start with 1
      preparedStatement.setString(1, pr);

      String n = (String) itemize.get("n");
      preparedStatement.setString(2, n);

      String yst = (String) jsonObject.get("yst");
      preparedStatement.setString(3, yst);

      String wh = (String) itemize.get("wh");
      preparedStatement.setString(4, wh);

      status = preparedStatement.executeUpdate();

    } catch (Exception e) {
      throw e;
    } finally {
      try {
          if (connect != null) {
             connect.close();
           }

         } catch (Exception e) {

         }
    }
    return status;
  }