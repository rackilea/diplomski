...
public class DetailsController {

    @RequestMapping(params = "action=viewDetails")
    public String showDetails(final ModelMap modelMap, final RenderRequest renderRequest) {
        ...
    }

}