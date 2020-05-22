@Service
public class ServiceImpl {

  private UserRepository userRepository;

  @Transactional
  public boolean deleteUser(String username){
     List<User> users =  userRepository.findByUsernameAndIsActiveTrue(username);
     for(User user : users){
         user.isActive(false);       
    }
  }
}