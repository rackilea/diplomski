@Component
public class StringToUser implements Converter<String, User> {

@Autowired
private UserService userService;

@Override
public User convert(String arg0) {
    Integer id = new Integer(arg0);
    return userService.findOne(id);
}
}