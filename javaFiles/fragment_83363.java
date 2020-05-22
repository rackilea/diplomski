@Controller
public class ImageReadFile{

    // this is for mapping your image related path. 
    @RequestMapping(value="/image/*")
    public void readImage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext sc = request.getServletContext();

        //here i uploaded my image in this path
        // You can set any path here
        String imagePath = "/home/somefolder/Workspaces/Images/";
        String [] fragmentFilename = request.getServletPath().split("/");

        //Check if image isn't set
        if(fragmentFilename.length <= 2){
            return;
        }

        String filename = fragmentFilename[2];
        String requestedImage = "/"+filename;

        if(filename == null){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        File image = new File(imagePath, URLDecoder.decode(requestedImage, "UTF-8"));

        if(!image.exists()){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        String contentType = sc.getMimeType(image.getName());
        response.reset();
        response.setContentType(contentType);
        response.setHeader("Content-Length", String.valueOf(image.length()));
        Files.copy(image.toPath(), response.getOutputStream());
    }

}