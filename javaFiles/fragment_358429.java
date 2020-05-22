/**
 * Demo API controller.
 *
 * @since 1.0.0
 */
@Controller
@RequestMapping("${url.home}")
public class DemoController {

    /**
     * Demo GET method binding.
     *
     * @return <code>String</code>
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getHome() {
        return "home";
    }

}