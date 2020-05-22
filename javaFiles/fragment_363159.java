private LoggedUsersService loggedUsersService;
public class LoggedUserController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        // set view name and optionaly whant you need to do
        mav.setViewName("loggedusers")
        mav.addObject("userList", loggedUserService.getLoggedInUsers());
        return mav;
    }
    public void setLoggedUsersService(LoggedUserService loggedUsersService) {
        this.loggedUsersService = loggedUsersService; 
    }
}