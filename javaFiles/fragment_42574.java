@WebServlet("/path/to/controller")
public class FileUploadToWSServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        //consume the data from JSP

        //pass the data received from JSP
        //to send it to consume the JAX-WS service
    }
}