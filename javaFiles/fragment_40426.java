@Controller
public class GreetingController {       

@RequestMapping("/greeting")
@ResponseBody
public Resource<Greeting> greeting(
@RequestParam(value = "name", required = false, defaultValue = "World") String name) {

Resource<Greeting> resourceResponse = new Resource<Greeting>("Some String");
resourceResponse.add(linkTo(methodOn(GreetingController.class).greeting("Some String")).withSelfRel());
return resourceResponse;
   }
}