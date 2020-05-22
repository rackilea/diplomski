@Controller("/signup")
public class SignUpController {
    @RequestMapping(method=RequestMethod.GET)
    public String signUpForm(){
        ...
    }
    @RequestMapping(method=RequestMethod.POST)
    public String crearUsuario(HttpServletRequest request){
        ...
    }