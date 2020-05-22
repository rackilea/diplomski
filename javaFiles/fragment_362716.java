public class RenderSceneServlet extends HttpServlet {
    protected void doGet(HttServletRequest request, HttpServletResponse response) {
        String outputFile = "/path/to/output-file";

        // execute command to render a frame from scene.blend
        Runtime runtime = Runtime.getRuntime();
        Process exec = runtime.exec("blender -b scene.blend -o " + outputFile + " -F JPEG -x 1 -f 1");

        // wait for blender to finish
        exec.waitFor();

        // serve the rendered file
        File file = new File(outputFile);
        byte[] bytes = FileUtils.readFileToByteArray(file);
        response.setContentLength(bytes.length);
        response.setContentType("image/jpeg");
        response.getOutputStream().write(bytes);
    }
}