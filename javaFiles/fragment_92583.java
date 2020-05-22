char []passChars=passwordField.getPassword();
   if(passChars!=null) { 
       String pass=new String(passChars);
       String sql="SELECT employee_ID,employee_password FROM user 
                             where user=? and employee_password=?";
       PreparedStatement ps=conn.prepareStatement(sql);
       ps.setString(1,user);
       ps.setString(2,pass);
       ResultSet rs=ps.executeQuery();
       if(rs.next()) {
          //found
       }
       else{
          //not found
       }
       rs.close();
       ps.close();
       conn.close();
   }