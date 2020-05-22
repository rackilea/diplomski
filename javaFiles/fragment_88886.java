@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    MyUserRepository myUserRepository;

    //Principal
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        //Here I get the User that I defined for my own domain structure
        MyUser myUser = myUserRepository.findFirstByUsername(s);

        //Here I return a new User object, in this case MySpringUser is
        //just a class that  extends from User class, its constructor 
        //receive myUser object as parameter in order to get my own custom fields later   
        return new MySpringUser(myUser,AuthorityUtils.createAuthorityList("ADMIN"));

    }
}