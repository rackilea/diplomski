Connection conn = null;
   try{
       String userName = "root";
       String password = "";
       String url = "jdbc:mysql://localhost/cms";
       Class.forName ("com.mysql.jdbc.Driver");
       conn = DriverManager.getConnection (url, userName, password);
   }
   catch (Exception e){
       System.err.println (e.getMessage());
   }finally{
       if(conn!=null){
          try{
             conn.close();
          }catch(Exception ex) { }
       }
    }