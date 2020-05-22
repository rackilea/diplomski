try
   {

    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    String connectionQuery="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=path upto the database;uid=; pwd=password here;";  

    con = DriverManager.getConnection(connectionQuery,"",""); 
    st=con.createStatement();
    stmt=con.createStatement();

   }
    catch(Exception ex)
    {

     System.out.println("exception is"+ex);
    }