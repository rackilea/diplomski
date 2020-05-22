@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value={"/login"}, method=RequestMethod.GET)
    public ModelAndView showLoginPage() {
        return new ModelAndView("loginForm");
    }

    @RequestMapping(value="/success-login", method=RequestMethod.GET)  
    public String successLogin() {  
        return "forward:/dashboard/dashboard";
    } 

    @RequestMapping(value="/error-login", method=RequestMethod.GET)  
    public ModelAndView invalidLogin() {  
        ModelAndView modelAndView = new ModelAndView("loginForm");  
        modelAndView.addObject("error", true);  
        return modelAndView;  
    }  

    @RequestMapping(value="/logout", method=RequestMethod.POST)  
    public ModelAndView logout() {  
        return new ModelAndView("dashboardForm");
    }  
}