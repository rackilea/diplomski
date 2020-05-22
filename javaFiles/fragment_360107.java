import org.springframework.security.core.userdetails.User;
@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    MyMongoRepo myMongoRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> dummyAuthorityForExample = Arrays.asList(new  SimpleGrantedAuthority("ROLE_ADMIN"));
        MyMongoUser mongoUser= myMongoRepo.findByUsername(s);
        User user = new User(mongoUser.getUsername(), mongoUser.getPassword(),dummyAuthorityForExample);
        return user;
    }
}