try{ 
     Class.forName("Mydrivername").newInstance();
     Connection con=DriverManager.getConnection(connectionurl,id,password); 
     PreparedStatement ps=(PreparedStatement) con.preparedStatement("select *    from datavasetablename");
     ResultSet rs= ps.executeQuery();
     while(rs.next())
     {
         row = new YourRowType();// Change this line to the correct type of    the row object
         row[0]= rs.getInt("Id"); 
         row[1]= rs.getString("name"); 
         mytablemodel.addRow(row);
         frame.show();
     }
  }
  catch(Exception e)
  {

  }