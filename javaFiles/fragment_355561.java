@Controller
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/admin/userlist")
    public String userList(Model model,@RequestParam(defaultValue = "") String email){
        model.addAttribute("users",userServices.findByEmailLike(email));
        return "/admin/userlist";
    }

    @GetMapping("/admin/useractions")
    public String userActions(){
        return "/admin/useractions";
    }

    @PostMapping("/admin/useractions")
    public String updateUser(@ModelAttribute User user) {
        userServices.update(user);

        return "/theNextView";
    }

    @ModelAttribute("user")
    public User getUser(@RequestParam(value = "id", required = false) Integer id) {
        return id !=null ? userServices.findOne(id) : new User();
    }
}