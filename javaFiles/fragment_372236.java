...
public class DetailsController {

    @RequestMapping(params = "action=viewDetails")    // render phase
    public String showDetails(final ModelMap modelMap, final RenderRequest renderRequest) {
        ...
    }

    ...
    // Empty method
    @RequestMapping(params = "action=viewDetails")    // action phase
    public void actionMethod() {
    }

}