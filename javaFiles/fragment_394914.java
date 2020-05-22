Component
public class DataLoaderRegistrar {

  @Autowired public UserRepository userRepo;

  @Autowired public GoalRepository goalRepo;

  @PostConstruct  
  public void registerRepos() {
    reposByName = new HashMap<String, JpaRepository>();
    reposByName.put(User.class.getSimpleName(), userRepo);
    reposByName.put(Goal.class.getSimpleName(), userRepo);
  }

  ...
}