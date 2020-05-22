...
public class DetailsController {

    @RequestMapping
    public String showDetails(final ModelMap modelMap, final RenderRequest renderRequest) {
        return "allDetails/details";
    }

}