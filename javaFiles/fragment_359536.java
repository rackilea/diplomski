@Controller
@RequestMapping(value = "/users")
public class UserController {

    @RequestMapping(params = "register")
    public String createForm(Model model) {
        model.addAttribute("user", new Customer());
        return "user/register";
    } 

}