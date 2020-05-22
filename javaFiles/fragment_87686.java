@WebServlet("/UploadHandler")
@MultipartConfig
public class UploadHandler extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
        Part imageToUpload = request.getPart("ImageToUpload");
        String imageFilename = getFilename(imageToUpload);
        InputStream imageContent = imageToUpload.getInputStream();
        String captionBox = getValue(request.getPart("CaptionBox"));

        // ...
    }

    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }

    private static String getValue(Part part) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream(), "UTF-8"));
        StringBuilder value = new StringBuilder();
        char[] buffer = new char[1024];
        for (int length = 0; (length = reader.read(buffer)) > 0;) {
            value.append(buffer, 0, length);
        }
        return value.toString();
    }

}