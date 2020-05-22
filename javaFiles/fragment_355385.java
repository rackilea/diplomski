@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;  // Here you need to have a Bean 
                    // Implementing this UserRepository as an autowire candidate
    ...
}