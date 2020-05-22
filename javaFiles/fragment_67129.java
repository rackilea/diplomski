@RestController
@RequestMapping("/rest")
public class NavigationController {

    @RequestMapping(method = RequestMethod.GET)
    public List<String> getShops() {
        return Arrays.asList("Shop1", "Shop2");
    }

}