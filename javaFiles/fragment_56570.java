@Controller
public class RouterController {

    @RequestMapping({
            "/error"
    })
    public String index() {
        return "forward:/index.html";
    }
}