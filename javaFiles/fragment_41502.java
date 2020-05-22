public class IndexController {

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String homePage() {
        return "myHomePage";
    }

    @RequestMapping(value="/otherPage", method = RequestMethod.GET)
    public String otherPage() {
        return "aDifferentPage";
    }
}