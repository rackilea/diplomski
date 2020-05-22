@Autowired
@Qualifier("configLocation")
String configLocation;

final static String EMPTY_CONFIG_LOCATION = "file:./default-empty-file.properties";

@RequestMapping(method = RequestMethod.GET)
public String SomeAction(){
    if (EMPTY_CONFIG_LOCATION.equals(configLocation)) {
        // redirect
        return "redirect:configPage";
    } else {
        // do the normal stuff
    }
}