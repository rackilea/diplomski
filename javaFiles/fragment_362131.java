@Controller
public class RestController {

    @RequestMapping(value = "/person", method = RequestMethod.PUT)
    public ModelMap addPerson(@RequestBody Person newPerson) {
        System.out.println("new person: " + newPerson);
        return new ModelMap(newPerson);
    }    
}