@RestController
@RequestMapping(value = "/api/something")
public class MyResource {

    @Autowired
    private UserDetails userDetails;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<String> getSomething() {
        // the userdetails should be injected here per request, some annotations missing?

        // do something
    }
}