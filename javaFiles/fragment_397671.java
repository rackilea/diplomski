private String userFolder;
private String fileName;
public void init(ServletConfig config) {
    userFolder= getServletContext().getInitParameter("ParentFolder");
    fileName= getServletContext().getInitParameter("FileName");
}

public doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException){

     String userName = request.getParameter("UserName");
     String location=""


          if(userName != null){
              location +="/"+userName;
               if (!location .exists()) {
                   UploadeFile(location );
                }
       }

 }


 private void UploadeFile(String location ){

    String file = location+"/"+fileName;
    //Code to upload the file

    MoveFile(file);//Move to different location
  }