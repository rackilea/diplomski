@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    PrintWriter out=response.getWriter();
    int customerId = Integer.valueOf(request.getParameter("customerId"));
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Vehicle", "root", "");
        PreparedStatement ps = con.prepareStatement("SELECT fistname,telephone FROM customers WHERE customerid=?");
        ps.setInt(1, customerId);
        ResultSet result=ps.executeQuery();
        if(result.next()){

            /* set response content type header: jQuery parses automatically response into a javascript object */
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");

            /* construct your json */
            JsonObject jsonResponse = new JsonObject();
            jsonResponse.put("firstname", result.getString("firstname"));
            jsonResponse.put("telephone", result.getString("telephone"));            

            /* send to the client the JSON string */
            response.getWriter().write(jsonResponse.toString());
           // "{"firstname":"first name from db","telephone":"telephone from db"}"

        }

    } catch (ClassNotFoundException ex) {
        Logger.getLogger(GetCustomerDetails.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(GetCustomerDetails.class.getName()).log(Level.SEVERE, null, ex);
    }

}