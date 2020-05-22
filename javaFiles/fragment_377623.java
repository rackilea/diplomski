if (rs.next()) {           
    String username =  rs.getString("uname");
    String email =  rs.getString("email");
    String rolle =  rs.getString("role");
    session.setAttribute("customer_name", username); 

    int usser =  rs.getInt("id");
    session.setAttribute("customer_id", usser);