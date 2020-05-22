@Service
public class ListingInMemoryUserDetailsService implements UserDetailsService {
    private final Map<String, InMemoryUser> users;

    public ListingInMemoryUserDetailsService() {
        this.users = new HashMap<>();
    }

    public ListingInMemoryUserDetailsService(UserDetails... userDetails) {
        this.users = stream(userDetails)
            .collect(Collectors.toMap(UserDetails::getUsername, InMemoryUser::new));
    }

    public Collection<String> getUsernames() {
        return users
            .values()
            .stream()
            .map(InMemoryUser::getUsername)
            .collect(toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional
            .ofNullable(users.get(username))
            .orElseThrow(() -> new UsernameNotFoundException("User does not exist"));
    }
}