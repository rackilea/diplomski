public class UserServiceImpl() {

  private final UserRepository userRepository;
  private final MessageService messageService;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, MessageService messageService) {
    this.userRepository = userRepository;
    this.messageService = messageService;
  }