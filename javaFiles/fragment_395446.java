@Controller
@RequestMapping("/")
public class IndexController {

@RequestMapping(method = RequestMethod.GET)
public String getIndexPage() {
    return "index";
}

}