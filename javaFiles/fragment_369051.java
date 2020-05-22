@Controller
@RequestMapping(value = "/api")
public class ApiController {
 @RequestMapping(value = "/01/status", method = RequestMethod.GET)
    @ResponseBody
    public ServerStatusJSON getStatus(HttpServletResponse response) {
        ...
    }
}