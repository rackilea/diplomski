@Controller
public class DefaultDataController {
    private static final Logger logger = LoggerFactory.getLogger(DefaultDataController.class);

    @Autowired private ApplicationContext applicationContext;   

    @RequestMapping(value="/install", method=RequestMethod.POST)
    public String postinstall(@Valid  Install install, BindingResult result, Locale locale){
        logger.info("Welcome to Install Default Settings page ! POST METHOD : The client locale is {}.", locale);       
        DefaultDataInstall settings = new DefaultDataInstall(applicationContext);//create a constructor which acceps ApplicationContext object
        settings.install();
        return "install";
    }

    //other code
}