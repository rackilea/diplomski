@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    MyUserRepository myUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<MyUser> myUser = myUserRepository.findFirstByUsername(s);

        return myUser.map( (user) -> {
            return new MySpringUser(
                    user,
                    user.getMyAuthorities().stream().
                            map( authority ->
                                    new SimpleGrantedAuthority(authority.getName())).
                            collect(Collectors.toList()));
        }).orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}