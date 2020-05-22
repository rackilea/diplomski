@Controller
@RequestMapping("/app/user")
@ExposesResourceFor(User.class)
public class UserController {

    @Autowired
    private ProfileService profileService;

    @RequestMapping(value = "/{userid}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public HttpEntity<UserResource> get(@PathVariable("userid") long id) {
        UserResource resource = profileService.get(id);
        return new ResponseEntity<UserResource>(resource, HttpStatus.OK);
    }
}