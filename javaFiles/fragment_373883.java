@Controller
@RequestMapping("/path")
public class TestingController {
    @RequestMapping("/page")
    public String someOtherPage(HttpServletRequest request, HttpServletResponse response) {
        return "forward:/static/myWebpage.html";
    }
}