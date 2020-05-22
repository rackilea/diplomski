@Controller
public class StartController  {

    @Value("${timeOut}")
    private int defaultTimeout;

    @RequestMapping("login.do")
    public String login(HttpServletRequest request, HttpSession session, Model model) {     
        session.setMaxInactiveInterval(defaultTimeout);     
        return null;        
    }
}