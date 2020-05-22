@Controller
@SessionAttributes({"user"})
public class UsersController {

@Autowired
UsersBo usersBo;

@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
public ModelAndView login(
        @RequestParam(DSTAConstants.PARAM_EMAIL) String email,
        @RequestParam(DSTAConstants.PARAM_PSW) String psw, 
        Model model) {

    try {

        //This is a call to a DAO that find data in the database
        Users user = usersBo.checkLogin(email, psw);

        //If the dao found a User
        if (user != null) {

                //Put the user into the model
                model.addAttribute("user", user);

                return new ModelAndView("mainPage");

        } 

        else {
            model.addAttribute("msg","Utente non Trovato o Password Errata.");
            return new ModelAndView("login");
        }
    } 
    catch (Exception e) {
        model.addAttribute("msg", e.getMessage());
        System.out.println("Eccezione: " + e.getMessage());
        return new ModelAndView("login");
    }