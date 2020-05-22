PreparedStatement  ps= con.prepareStatement("SELECT * FROM USER where 
email=? and password=?");
 //putting value for placeholder (?)
               ps.setString(1,email);
               ps.setString(2,password);
                 ResultSet resultset= ps.executeQuery();
      //if there is row exist then do below
                if(resultset.next()){
               HttpSession hp = request.getSession(true);
             hp.setAttribute("name", resultset.getString("name"));
                  //getting name
                pw.println("<html><body><h1>Welcome "+resultset.getString("name")+"</h1></body></html>");
               } else {
                pw.println("<html><body><h1>invalid credentials</h1></body></html>");
                pw.println("<html><body><a href=login.html>go back</a></body></html>");
            }