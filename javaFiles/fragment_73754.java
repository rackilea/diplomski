@Controller
@RequestMapping("/locale")
public class LocaleController {

    @Autowired
    private LocaleService localeService;

    @RequestMapping(value = "/labels", method = RequestMethod.GET)
    public @ResponseBody List<Label> getAll() {
        return localeService.getAll();
    }
}