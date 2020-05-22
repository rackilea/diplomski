@Controller
public class LandingPageController {

@RequestMapping({"/","/home"})
public String showHomePage(Map<String, Object> model) {
    return "/WEB-INF/index.html";   
   }
}