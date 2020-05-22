@Service
public class TopTrumpUserDetailsServices implements UserDetailsService {

    @Autowired
    private UserLoginRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TopTrumpUser u = userRepo.findByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        return new User(u.getUsername(), u.getPassword(), authorities);
    }

}