@Controller
public class CustomErrorController implements ErrorController {
    private static final String PATH = "/error";

    @RequestMapping(value = PATH, produces = "text/html")
    public ModelAndView error() {
        return new ModelAndView("errorPage");
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

}