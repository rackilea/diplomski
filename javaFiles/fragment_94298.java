@Controller
public class AjaxController {

    @RequestMapping("/some/path/selectDomain.json", method=RequestMethod.GET)
    public ModelAndView processDomainSelection(@RequestParam(value="domain", required="true") String selectedDomain) {
        List<User> users = service.loadUsersForDomain(selectedDomain);
        ModelAndView mv = new ModelAndView("sojoView", "users", users);
        return mv;
    }
}