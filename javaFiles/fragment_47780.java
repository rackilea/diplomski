@Controller
public class LinkedInController {

    private static final Logger logger = LoggerFactory.getLogger(LinkedInController.class);

    @Inject
    private final LinkedIn linkedIn;

    public LinkedInController() {
        logger.info("Initialisation du controleur linkedIn.");
    }

    @RequestMapping(value = "linkedin")
    public ModelAndView categorize() {
        categorizeAndStore(linkedIn);
        return mav;
    }

    @Async
    public Future<Boolean> categorizeAndStore( LinkedIn source) {
        // java stuff
        return new AsyncResult<Boolean>(true);
    }
}