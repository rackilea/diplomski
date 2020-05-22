@Controller
public class GreetingController {

 //Autowire your CrudRepo of Greeting
   @Autowired
   GreetingRepository repository;

@RequestMapping(value="/greeting", method= RequestMethod.GET)
public String greetingForm(Model model) {
    model.addAttribute("greeting", new Greeting());
    //create a new Greeting() Object and set your values to it.
    //create a constructor if the values are not that much.
    Greeting greeting = new Greeting();
    greeting.setContent(yourContent);
    repository.save(greeting);
    return "greeting";
}

@RequestMapping(value="/greeting", method=RequestMethod.POST)
public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
    model.addAttribute("greeting", greeting);
    //create a new Greeting() Object and set your values to it.
    //create a constructor if the values are not that much.
    Greeting greeting = new Greeting();
    greeting.setContent(yourContent);
    repository.save(greeting);
    return "result";
}
}