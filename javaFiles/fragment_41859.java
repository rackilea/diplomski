@Controller
public class ErrorController
{
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView addresses()
    {
        return new ModelAndView("error"); // Or redirect to /welcome
    }
}