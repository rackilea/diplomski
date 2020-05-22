@RequestMapping("/index")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String homePage() {
        return "myHomePage";
    }`
}