@Controller
public class InfoTextFormController {       
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView createForm() throws Exception {
        return new ModelAndView("admin", "command", new InfoText());
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("command") InfoText infoText) {
        ...
    }       
}