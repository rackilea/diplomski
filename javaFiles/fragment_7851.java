public class CommonController{

    @Autowired
    private SecurityService securityService;

    @ModelAttribute
    public void addSecurityAttributes(Model model){
        User user = securityService.getCurrentUser();
        model.addAttribute("currentLogin", user.getLogin());

        //... add other attributes you need to show
    }

}