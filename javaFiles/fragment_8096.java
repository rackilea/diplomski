if (rs.next()) {
             request.setAttribute("fname",rs.getString("Firstname");
             request.setAttribute("lname",rs.getString("Latname");            
             RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
             rd.include(request, response);
 }