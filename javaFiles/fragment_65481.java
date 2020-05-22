@Controller
@RequestMapping("/main")
public class MainController {


@RequestMapping(method = RequestMethod.POST, params = "procesar", value="/theJspName")
public String procesaSubmit(@ModelAttribute("municipioBean") MunicipioBean municipioBean,        BindingResult result, HttpServletRequest request, ModelMap model) {    
  return ConstantesAbre.PASOS_JSP;
}