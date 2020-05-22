@Controller
@RequestMapping("/requests")
public class RequestMappingController {
    @Autowired
    private RequestMappingHandlerMapping handler;

    @RequestMapping(method = RequestMethod.GET)
    public String showDoc(Model model) {
        model.addAttribute("methods", handler.getHandlerMethods());
        Map<RequestMappingInfo, HandlerMethod> map = handler.getHandlerMethods();

        Set<RequestMappingInfo> mappings = map.keySet();
        Map<String, String> reversedMap = new HashMap<String, String>();
        for(RequestMappingInfo info : mappings) {
            HandlerMethod method = map.get(info);
            reversedMap.put(method.toString(), info.getPatternsCondition().toString());
        }
        model.addAttribute("methods", reversedMap);

        return "showDoc";
    }
}