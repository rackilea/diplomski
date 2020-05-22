@RestController
@RequestMapping("/foo")
public class ServicesController {

    @RequestMapping(method=RequestMethod.GET)
    public Something doStuff() {
    }
}