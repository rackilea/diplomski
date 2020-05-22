@Component
public abstract class AbstractBaseController {
    @Autowired private SomeService someService;

    @ModelAttribute("value")
    protected String getValue() {
        return someService.getGenericValue());
    }
}