@Controller
@RequestMapping("/some/path/selectDomain.json")
public class SelectDomainController {
    public class FormBean {
        protected Domain domain;
        public Domain getDomain() {
            return domain;
        }
        public void setDomain(Domain domain) {
            this.domain = domain;
        }
    }

    @ModelAttribute("command")
    public FormBean getCommand() {
        return new FormBean();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        // this custom editor knows how to load a Domain object from the domainValue string
        // if it fails to convert, it can throw an exception, which will result in 
        // an error being logged against the "domain" field
        binder.registerCustomEditor(Domain.class, "domain", new DomainLookupEditor(domainService));
    }

    @RequestMapping(method=RequestMethod.POST)
    public String selectedDomain(@ModelAttribute("command") FormBean command,
                                       BindingResult result,
                                       Model model,
                                       HttpServletRequest request) {
        if (result.hasErrors()) {
            return "sojoView";
        }
        Domain domain = command.getDomain();
        List<User> users = domain.getUsers();
        model.addAttribute("users", users);
        return "sojoView";
    }
}