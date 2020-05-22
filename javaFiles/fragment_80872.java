@Controller
public class OpenRepairsRest {

    @RequestMapping(value = "/openRepairsClient/{username}")
    public @ResponseBody
    List<Shop> openRepairsInJson(@PathVariable("username") String username) {

        Shop exampleShop = new Shop();
        exampleShop.setName("exampleName");
        exampleShop.setStaffName(new String[] { username });

        List<Shop> openShops = new ArrayList<Shop>();
        openShops.add(exampleShop);

        return openShops;
    }
}