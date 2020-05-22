@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status"); // Retrieves <input type="text" name="status">
        Part uploadedFile = request.getPart("uploadedFile"); // Retrieves <input type="file" name="uploadedFile">
        InputStream content = uploadedFile.getInputStream();
        // ... (do your job here)
    }

}