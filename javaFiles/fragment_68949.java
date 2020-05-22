@Controller
public class SignUpController {
    @RequestMapping(value="/signup", method=RequestMethod.GET)
    public String signUpForm(){}
    @RequestMapping(value="/signup",method=RequestMethod.POST)
    public String crearUsuario(HttpServletRequest request){}
}