public class ImageDB extends HttpServlet {
// ...
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 // ...
byte[] bytes = blob.getBytes((long)1, (int)blob.length());

ServletOutputStream out = response.getOutputStream();
out.write(bytes);
out.close(); // Close stream
// ...

  }


}