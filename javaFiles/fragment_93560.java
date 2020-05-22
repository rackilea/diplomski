protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
    //opening a connection before accessing db
    cn=ConnectionFactory.getConnection();

    String logintype=request.getParameter("t1");
    String username=    request.getParameter("t2");
    String  password=   request.getParameter("t3");
    PreparedStatement ps=null;
    ResultSet rs=null;
       String result="";
    try {
        ps=cn.prepareStatement("select * from mydb.isevausers where logintype=? and passwords=? and username=?");
        ps.setString(1,logintype);
        ps.setString(2,password);
        ps.setString(3,username);
         rs=ps.executeQuery();
         boolean b=rs.next();

        // RequestDispatcher dispatcher=null;

         if(b==true)  
         {
            /* response.sendRedirect("form_1_IRCTC_PaymentEntry.html");*/
             result="form1";
             /*dispatcher =getServletContext().getRequestDispatcher("/form_1_IRCTC_PaymentEntry.html");

             dispatcher.forward(request,response);*/

             System.out.println("entered"); 
         }          
         else{     
             result="notfound"; 
             System.out.println("not found");                   
         }
            response.getWriter().write(result); 
    } catch (SQLException e) {   
        // TODO Auto-generated catch block  
        e.printStackTrace();  
    } 

    finally{ 
        if(cn!=null)
        {
            try {
                cn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(ps!=null)
        {
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(rs!=null)
        {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } 
    }

}