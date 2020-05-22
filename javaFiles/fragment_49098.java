@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping(value = "findById", method = RequestMethod.POST)
    @ResponseBody
    public User findById(@Param("id") Long id) {
        return userDAO.findOne(id);
    }
}