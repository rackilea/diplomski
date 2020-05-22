@Controller
public class CBController

@Resource
private TreeGridResponse gridResponse;

@RequestMapping(value="/CourtBranch/LoadTreeView", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public String cbTree() {
    return this.gridResponse.cbBTreeAsJson(this.gridResponse.get());
}