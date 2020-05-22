@Controller
public class UserController {

    @RequestMapping("/users/{register}")
    public String createForm(Model model) {
        model.addAttribute("user", new Customer());
        return "user/register";
    } 

}