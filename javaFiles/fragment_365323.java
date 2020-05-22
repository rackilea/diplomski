@Controller
public class AppController{

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, Model model, HttpServletRequest request) {

        ModelAndView view = new ModelAndView();
        if (error != null) {
            view.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            view.addObject("msg", "You've been logged out successfully.");
        }

        view.setViewName("your-login-page");  
        return view;
    }
}