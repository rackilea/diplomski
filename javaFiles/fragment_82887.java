@Controller("multiParamLinkController")
@RequestMapping(value = "/multiParamLink")
public class MultiParamLinkController
{

    @RequestMapping(value =
    { "/",
      "" }, method = RequestMethod.GET)
    public String testMultiParamsGenerator(Model model)
    {
        List<String> paramNames = new ArrayList<>();
        paramNames.add("fooValue");
        paramNames.add("barValue");
        paramNames.add("lang");

        model.addAttribute("fooValue", "foo");
        model.addAttribute("barValue", "bar");
        model.addAttribute("lang", "US_us");

        model.addAttribute("paramNames", paramNames);

        return "multiParamLink/multiParamLink.html";
    }

}