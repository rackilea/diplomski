@Controller
public class Controller {

    @Autowired private ResourceLoader loader;

    private String getCss(String cssFileName) {
        try {
            File file = loader.getResource("classpath:/static/css/" + cssFileName + ".css").getFile();
            return new String(Files.readAllBytes(Paths.get(file.getPath())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "css not found";
    }
}