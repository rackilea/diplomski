@RestController
@RequestMapping("/hello")
public class GreetingsController {

    @Autowired
    private GreetingRepository repo;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Greeting> getGreetings() {
        return repo.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Greeting getGreeting(@PathVariable long id) {
        return repo.findOne(id);
    }
}