@Controller
public class LoginController() {
  @GetMapping("/login")
  public String login(Model model) {
        return "/login";
  }
}