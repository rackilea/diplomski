@Controller
public class UsersSettingsController {

    @Autowired
    UserSettingsDefaultService userSettingsService;


    @RequestMapping(value="/userSettings/dynamic/userSettings", method=RequestMethod.GET)
    public ModelAndView get() throws Exception {
        ModelAndView mav = new ModelAndView();
        ObjectMapper mapper = new ObjectMapper();


    User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    UserSettings userSet = userSettingsService.getUserSettingsByUser(user);

    mav.addObject("userSettingsJSON", mapper.writeValueAsString(userSet));

    mav.setViewName("userSettings/dynamic/filter");


        return mav;
    }
}