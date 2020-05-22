@Component
@RequestMapping("/bundle")
public class ResourceBundleController {

    @Autowired
    private MessageResolveService messageResolveService;


    @RequestMapping(value = "/locales.js")
    public ModelAndView strings(HttpServletRequest request) {

        // Call the string.jsp view
        return new ModelAndView("/WEB-INF/includes/locales.jsp", "keys", messageResolverService.getMessages(LocaleContextHolder.getLocale()));
}