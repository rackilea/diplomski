Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  // set this to a MS Access DB you have on your machine
   String filename = "d:/DB.accdb";
   String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=";
   database+= filename.trim() + ";DriverID=22;}"; // add on to the end 
   // now we can get the connection from the DriverManager
   Connection con = DriverManager.getConnection( database ,"","");