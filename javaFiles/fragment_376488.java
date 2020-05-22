@Controller
@RequestMapping("/admin")
public class AdminController{
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ModelAndView admin(HttpSession session){

    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/addUser")
    public ModelAndView user(HttpSession session){

    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/addBook")
    public ModelAndView book(HttpSession session){

    }

}