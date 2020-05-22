@Component
public class UserMapperResolver {

    @Autowired
    private UserRepository userRepository;

    @ObjectFactory
    public User resolve(BaseUserDto dto, @TargetType Class<User> type) {
        return dto != null && dto.getId() != null ? userRepository.findOne(dto.getId()) : new User();
    }

}