@RestController
@RequestMapping(value = "/api/1.0")
public class MyRestController
.... 
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Foo getFoo(RequestEntity<Bar> request) {