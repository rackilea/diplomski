@Controller
@RequestMapping(value = "/sample")
public class SampleController
{
    @RequestMapping(value = "/getText", method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public String testMethod(@RequestParam("locale") final  String locale) {
        return  "Hello Worlds TEXT";
    }
}