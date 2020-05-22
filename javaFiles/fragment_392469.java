@Controller
@Scope(value = "request")
public class HomeController {

 @RequestMapping(value = "/", method = RequestMethod.GET)
 public String Home(HttpServletRequest request, HttpServletResponse response) throws 
 Exception {
    List<NewsDoc> list = getTopNewsList();
    request.setAttribute("list", list);
    return "Home";
}