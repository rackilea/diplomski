@Controller
public class RESTController{

    @RequestMapping(value="testing", method=RequestMethod.GET)
    public @ResponseBody String TestingXml(HttpServletRequest request, @RequestParam String welcome){
        return welcome;
    }

}