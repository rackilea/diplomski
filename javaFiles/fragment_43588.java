<%
    Connection conn = null;

    try {

        String uname=request.getParameter("userName");
        String pword=request.getParameter("passWord");
        String fname=request.getParameter("firstName");
        String lname=request.getParameter("lastName");
        String email=request.getParameter("emailAddress");

        String dbURL = "jdbc:mysql://localhost:3306/Users";
        String user = "root";
        String pwd = "password";
        String driver = "com.mysql.jdbc.Driver";

        String query = "INSERT INTO User (UserName, UserPass, FirstName, LastName, EmailAddress) " +
                       "VALUES ('"+uname+"','"+pword+"','"+fname+"','"+lname+"','"+email+"')";
        Class.forName(driver);
        conn = DriverManager.getConnection(dbURL, user, pwd);
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
        statement.close();

        out.println("Data is successfully inserted!");

    } catch( ClassNotFoundException e ){
        System.err.println( "Database Driver class not Found!" );
        e.printStackTrace();
    } catch( SQLException e ){
        e.printStackTrace();
    } finnaly {
        try {
            if ( conn != null ) {
                conn.close();
            }
        } catch ( SQLException e ) {
            System.err.println( "Problems when closing connection" );
            e.printStackTrace();
        }
    }
%>