PreparedStatement ps = null;
Connection con = null;
ResultSet rs = null;
Statement stmt = null;

String strName = "";

strName = request.getParameter("stFullName");

try {
     DBConnect dbConnect = new DBConnect();
     con = dbConnect.getConnection();
     stmt = con.createStatement();                   
     rs = stmt.executeQuery("SELECT * FROM members");