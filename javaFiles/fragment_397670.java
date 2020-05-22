private String userFolder;

public void init(ServletConfig config) {
    userFolder= getServletContext().getInitParameter("ParentFolder");
}

public doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException){

     String userName = request.getParameter("UserName");
     String location=""


          if(userName != null){
              location +="/"+userName;
               if (!location .exists()) {
                 location .mkdirs(); //If does not exists then create folder
                }
       }

 }