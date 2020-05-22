@Controller
public class SampleRestController {

    @RequestMapping(value = "/helloSample", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String helloSample() {
        return "Finally!";
    }
}