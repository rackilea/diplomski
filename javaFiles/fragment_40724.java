@RequestMapping("/test")
@Controller
public class TestController {
    @RequestMapping(method = RequestMethod.GET)
    public String testMestod(HttpServletRequest request)
    {
        request.getSession().setAttribute("testVariable", "Test Values!!");
        return "testJsp";
    }
}