@Controller
@RequestMapping("/data")
public class UserDataController
{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView data(final Principal principal) {
        Assert.notNull(principal); // throw if assertion fails
        Assert.hasText(principal.getName());

        final UserData userData = this.userService.findByUserName(principal.getName());
        Assert.notNull(userData, "userData not found");

        return new ModelAndView("userData", "userData", userData);
    }
}

@Service("userService")
public class userService 
{
    private static final String USERDATA_CACHE = "com.acme.foo.UserData";

    @Autowired
    private UserDataRepository userDataRepository;

    @Cacheable(USERDATA_CACHE)
    public UserData findByUserName(final String userName) {
        return this.userDataRepository.findByUserName(userName);
    }
}

@Repository
public class UserDataRepository
{
    // or use spring-data-jpa

    public UserData findByUserName(final String userName) {
        // query table userData and create an UserData from results.
    }
}