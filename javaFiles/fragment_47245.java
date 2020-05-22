public class DatabaseAccess extends HttpServlet{

public void doGet(HttpServletRequest request,
                HttpServletResponse response)
        throws ServletException, IOException
{
  //you can use your own connection thing in you don't like the below code
  static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
  static final String DB_URL="jdbc:mysql://localhost/TEST";


  static final String USER = "root";
  static final String PASS = "password";

  try{

     Class.forName("com.mysql.jdbc.Driver");


     Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

     // Execute SQL query
     Statement stmt = conn.createStatement();
     String sql;
     sql = "YOUR QUERY. YOU SAID YOU ALREADY KNOW THIS";
     ResultSet rs = stmt.executeQuery(sql);

     // Extract data from result set
     while(rs.next()){
        //Retrieve by column name
        String fname = rs.getString("first");
        String flast = rs.getString("last");
     }

     rs.close();
     stmt.close();
     conn.close();
  }catch(SQLException se){        
     se.printStackTrace();
  }catch(Exception e){
     e.printStackTrace();
  }finally{        
     try{
        if(stmt!=null)
           stmt.close();
     }catch(SQLException se2){
     }
     try{
        if(conn!=null)
        conn.close();
     }catch(SQLException se){
        se.printStackTrace();
     }
  } 

//get the session and set the values
HttpSession session = request.getSession();    
session.setAttribute("fname", fname);
RequestDispatcher rd=req.getRequestDispatcher("/whateveristhejspname.jsp");
rd.forward(req, resp);

 }
}