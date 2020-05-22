private Connection conn = null;
  public void connect(){
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      conn = 
        DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/db_name",
                                    "username","password");

      ...

    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }catch(Exception e){e.printStackTrace();}   
  }