@MultipartConfig
public class UploadServlet extends HttpServlet
{
  protected void service(HttpServletRequest request, 
   HttpServletResponse responst) throws ServletException, IOException
  {
  Collection<Part> parts = request.getParts();
  if (parts.size() != 3) {
     //can write error page saying all details are not entered
   }

   Part filePart = httpServletRequest.getPart("photo");
   InputStream imageInputStream = filePart.getInputStream();
   //read imageInputStream
   filePart.write("somefiepath");
   //can also write the photo to local storage

   //Read Name, String Type 
   Part namePart = request.getPart("name");
   if(namePart.getSize() > 20){
       //write name cannot exceed 20 chars
   }
   //use nameInputStream if required        
   InputStream nameInputStream = namePart.getInputStream();
   //name , String type can also obtained using Request parameter 
   String nameParameter = request.getParameter("name");

   //Similialrly can read age properties
   Part agePart = request.getPart("age");
   int ageParameter = Integer.parseInt(request.getParameter("age"));



}

}