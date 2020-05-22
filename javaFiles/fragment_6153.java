@Controller
@RequestMapping(value = "/path", method = RequestMethod.POST)
public class Control {
    public String handler(@Valid Nest nest, BindingResult res_nest){
             //Business logic
    }
}