@Controller
public class HelloController {

    @Autowired
    ResponseObject responseObject
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(ModelMap model) {
        model.addAttribute("responseObject", new ResponseObject());
        return "Hello World";
    }
}