public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       HttpSession session = (request.getSession());
         //check if there is a loggedInUser session variable
         if(null == session.getAttribute("loggedInUser")){              
            request.setAttribute("pleaselogin", "Not Logged In. Login or register to do this.");            
             RequestDispatcher rd=request.getRequestDispatcher("Error.html");   
               rd.forward(request,response);        
        }else{

   String username = (String) session.getAttribute("loggedInUser");


   //do database logic

}

}