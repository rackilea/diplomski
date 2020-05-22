@Service
public class SPResolver {

public SPResolver() {
}

@Autowired
private CurrentUserContext currentUser;

@Autowired
private ConnectionRepository connectionRepository;