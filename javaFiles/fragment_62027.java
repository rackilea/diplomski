String query = "INSERT INTO EMPLOYEE (DOB) VALUES (?)";

con = db.createConnection();
 try{
     ps = con.prepareStatement(query);
     ps.setDate(1, java.sql.Date.valueOf("2012-01-20"));
     //Or use
     //  ps.setTimestamp(1, new Timestamp(DOB.getTime())); 
     ps.executeUpdate();
    }catch(Exception ex){
       System.err.print(ex);
  }