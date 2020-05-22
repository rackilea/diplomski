{ 
                    String pass1 = request.getParameter("password");
                    String email = request.getParameter("email");

         //first check if valid login details (seperate it out so you can be more specific in the error you give back, and you don't have to repeat yourself)
         if(User.validate(email,pass1)){
             // s.invalidate(); //this isn't really necessary here, normally you invalidate the session variables when the user logs out. If a different user logs in (whilst one is already logged in), then any session variables you have set would override it.
              String url = "/RegularUser.jsp";
              String role = "regular";
              //now check if user is admin
              if(User.isAdmin(email)){
                url = "/Admin.jsp" 
                role = "admin";
              }
          //set your session variables
          //s.setAttribute("user_email", email);
          //s.setAttribute("user_role", role);

           forwardTo(ctx, request, response, url);

         }else{

        //wrong login details - set values back in form
        request.setAttribute("email",email); 
        request.setAttribute("pass", pass1);
        forwardTo(ctx, request, response, "/Login.jsp");
         }
}