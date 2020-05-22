public class HTMLTemplateEngine extends TemplateEngine {

    @Override
    public String render(ModelAndView modelAndView) {
        try {
            // If you are using maven then your files
            // will be in a folder called resources.
            // getResource() gets that folder 
            // and any files you specify.
            URL url = getClass().getResource("public/" + 
                        modelAndView.getViewName());

            // Return a String which has all
            // the contents of the file.
            Path path = Paths.get(url.toURI());
            return new String(Files.readAllBytes(path), Charset.defaultCharset());
        } catch (IOException | URISyntaxException e) {
            // Add your own exception handlers here.
        }
        return null;
     }
}