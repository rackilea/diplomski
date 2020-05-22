@Controller
public interface AuthenticationController {
  ModelAndView home(HttpServletRequest request, HttpServletResponse response);
}

@Controller
public class AuthenticationControllerImpl implements AuthenticationController {

@RequestMapping(value="/home.html",method=RequestMethod.GET)
@Transactional
@Override
ModelAndView home(HttpServletRequest request, HttpServletResponse response){
.....
}
}