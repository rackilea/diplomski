@Controller
@RequestMapping("/foo")
public class JSONController {

    /**
     * This method will return [{"prodId":1, "prodName":"A"}, {"prodId":2, "prodName":"B"}, ... ]
     */
    @ResponseBody
    @RequestMapping(value="/bar", method = RequestMethod.GET)
    public List<ProdBean> getJson() {
        List<ProdBean> results = ...
        return results;
    }
}