PreparedStatement s = null;

 try {
    Class.forName("com.mysql.jdbc.Driver");

    connect =  DriverManager.getConnection("jdbc:mysql://localhost/client", "rootroot", "rootroot");

    s = connect.prepareStatement("UPDATE client SET stock = stock - 1 WHERE id = ?");

    String strCustomerID = request.getParameter("clientId");
    String strName = request.getParameter("txtName");
    String strEmail = request.getParameter("txtEmail");
    String strStock= request.getParameter("txtStock");
    String strBudget = request.getParameter("txtBudget");

    s.setString(1, strCustomerID);
    s.executeUpdate();