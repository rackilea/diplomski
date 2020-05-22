@Controller
public class Controller{
  @GetMapping(value =  "/")
  public String getPersonForm(Model model){
     PersonForm personForm = new PersonForm();
     model.addAttribute(personForm);
  }
}