@Entity
// in your case this would map to the User table
public class Profile implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // you should probably use bean validation / jpa to assure uniqueness etc.
    private String name;
    ...

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles = ImmutableSet.<Role> of(new Role("USER"));
    ...
}

@Embeddable
// in your case this would map to the user_role table
public class Role implements GrantedAuthority {

    public final static Role USER = new Role("USER");
    public final static Role ADMIN = new Role("ADMIN");

    private String authority;

    ...

}

@Transactional
@Service
public class ProfileService implements UserDetailsService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository){
            this.profileRepository = profileRepository;
    }

    public Profile loadUserByUsername(String username) throws UsernameNotFoundException {
        Profile profile = profileRepository.findByUsername(username);

        // this is the only way to authenticate
        if (profile == null) {
            throw new UsernameNotFoundException("security.userNotFound");
        }

        return profile;
    }

// you may want to add profile creation etc.
...
}