@Component
public class OtherClass extends AbstractClass {

    @Autowired
    UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }
}