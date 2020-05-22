@MultipartConfig
public class addImage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Part filePart = request.getPart("file");
        InputStream fileContent = filePart.getInputStream();
}
}