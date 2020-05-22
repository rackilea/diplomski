@Controller
public class HttpErrorController {

    @RequestMapping(value="/error404")
    public String error404() {
        return "error404.jsp";
    }
}